package com.spring.springboot.namedContextFactory;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 演示 NamedContextFactory的功能
 * 2. 父子容器，子容器可以获取到父容器中的Bean,而父容器获取不到子容器的Bean，并且子容器之间也是互相隔离的
 * 3. 比如Ribbon就是利用NamedContextFactory，客户端对不同的服务采用不同的配置和策略
 */
public class CommonNameContextTest {
    private static final String PROPERTY_NAME = "test.context.name";

    @Test
    public void test() {
        /**
         * 创建了一个 AnnotationConfigApplicationContext,这个其实就是模拟了我们平常使用Spring框架的时候的根核心
         * ApplicationContext，所以我们将其命名为 parent。我们向里面注册了 BaseConfig，BaseConfig 里面的
         * BaseBean 会注册到 parent
         */
        //创建 parent context
        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext();
        //添加 BaseConfig 相关配置
        parent.register(BaseConfig.class);
        //初始化 parent
        parent.refresh();

        /**
         * 1. 创建testClient1，默认配置使用ClientCommonConfig。如果我们指定了 testClient1 的 parent ApplicationContext
         * 为parent，那么 parent 里面的 Bean 都能被 testClient1 里面的子 ApplicationContext 访问到
         * 2. 能访问到parent中的bean的原因：在testClient1.getInstance中，创建子环境，然后子环境设置父环境，然后在获取bean时，
         * 先去子环境中找，找不到时再去父环境中找
         */
        //创建 testClient1，默认配置使用 ClientCommonConfig
        TestClient testClient1 = new TestClient(ClientCommonConfig.class);
        //设置 parent ApplicationContext 为 parent
        testClient1.setApplicationContext(parent);

        /**
         * 1. 创建 service1 与 service2 以及指定对应额外的配置类。service1 会创建 ClientCommonConfig、Service1Config1 和
         * Service1Config2 里面配置的 Bean。service2 会创建 ClientCommonConfig 和 Service2Config 里面配置的 Bean
         * 2. 这里的service1和service2,模拟的是在微服务中同一个客户端分别调用服务1和服务2时所使用的不同的配置和组件，例如：
         * A 微服务是一个简单的用户订单查询服务，接口返回速度很快，B 是一个报表微服务，接口返回速度比较慢。这样的话我们就不能
         * 对于调用微服务 A 和微服务 B 使用相同的超时时间配置。还有就是，我们可能对于服务 A 通过注册中心进行发现，对于服务 B
         * 则是通过 DNS 解析进行服务发现，所以对于不同的微服务我们可能使用不同的组件，在 Spring 中就是使用不同类型的 Bean
         */
        //创建 service1 与 service2 以及指定对应额外的配置类
        TestSpec testSpec1 = new TestSpec("service1", new Class[]{Service1Config1.class, Service1Config2.class});
        TestSpec testSpec2 = new TestSpec("service2", new Class[]{Service2Config.class});
        //将 service1 与 service2 的配置加入 testClient1
        List testSpecList = new ArrayList();
        testSpecList.add(testSpec1);
        testSpecList.add(testSpec2);
        testClient1.setConfigurations(testSpecList);


        // 延迟加载，开始创建子环境，子环境设置父环境
        BaseBean baseBean = testClient1.getInstance("service1", BaseBean.class);
        System.out.println("baseBean: " + baseBean);
        //验证正常获取到了 baseBean
        Assert.assertNotNull(baseBean);

        ClientCommonBean commonBean = testClient1.getInstance("service1", ClientCommonBean.class);
        System.out.println("commonBean: " + commonBean);
        //验证正常获取到了 commonBean
        Assert.assertNotNull(commonBean);

        Service1Bean1 service1Bean1 = testClient1.getInstance("service1", Service1Bean1.class);
        System.out.println("service1Bean1: " + service1Bean1);
        //验证正常获取到了 service1Bean1
        Assert.assertNotNull(service1Bean1);

        Service1Bean2 service1Bean2 = testClient1.getInstance("service1", Service1Bean2.class);
        System.out.println("service1Bean2: " + service1Bean2);
        //验证正常获取到了 service1Bean2
        Assert.assertNotNull(service1Bean2);

        BaseBean baseBean2 = testClient1.getInstance("service2", BaseBean.class);
        System.out.println("baseBean2: " + baseBean2);
        //验证正常获取到了 baseBean2 并且 baseBean2 就是 baseBean，即parent中的baseBean
        Assert.assertEquals(baseBean, baseBean2);

        ClientCommonBean commonBean2 = testClient1.getInstance("service2", ClientCommonBean.class);
        System.out.println("commonBean2: " + commonBean2);
        //验证正常获取到了 commonBean2 并且 commonBean 和 commonBean2 不是同一个,他们分别属于各自的环境
        Assert.assertNotNull(commonBean2);
        Assert.assertNotEquals(commonBean, commonBean2);

        Service2Bean service2Bean = testClient1.getInstance("service2", Service2Bean.class);
        System.out.println("service2Bean: " + service2Bean);
        //验证正常获取到了 service2Bean
        Assert.assertNotNull(service2Bean);
    }

    // proxyBeanMethods = false 表示BaseBean不从spring容器中获取
    @Configuration(proxyBeanMethods = false)
    static class BaseConfig {
        @Bean
        BaseBean baseBean() {
            return new BaseBean();
        }
    }
    static class BaseBean {}


    @Configuration(proxyBeanMethods = false)
    static class ClientCommonConfig {
        @Bean
        ClientCommonBean clientCommonBean(Environment environment, BaseBean baseBean) {
            //在创建 NamedContextFactory 里面的子 ApplicationContext 的时候，会指定 name，这个 name 对应的属性 key
            // 即 PROPERTY_NAME
            return new ClientCommonBean(environment.getProperty(PROPERTY_NAME), baseBean);
        }
    }
    static class ClientCommonBean {
        private final String name;
        private final BaseBean baseBean;

        ClientCommonBean(String name, BaseBean baseBean) {
            this.name = name;
            this.baseBean = baseBean;
        }

        @Override
        public String toString() {
            return "ClientCommonBean{" +
                    "name='" + name + '\'' +
                    ", baseBean=" + baseBean +
                    '}';
        }
    }



    @Configuration(proxyBeanMethods = false)
    static class Service1Config1 {
        @Bean
        Service1Bean1 service1Bean1(ClientCommonBean clientCommonBean) {
            return new Service1Bean1(clientCommonBean);
        }
    }
    static class Service1Bean1 {
        private final ClientCommonBean clientCommonBean;

        Service1Bean1(ClientCommonBean clientCommonBean) {
            this.clientCommonBean = clientCommonBean;
        }

        @Override
        public String toString() {
            return "Service1Bean1{" +
                    "clientCommonBean=" + clientCommonBean +
                    '}';
        }
    }



    @Configuration(proxyBeanMethods = false)
    static class Service1Config2 {
        @Bean
        Service1Bean2 service1Bean2() {
            return new Service1Bean2();
        }
    }
    static class Service1Bean2 {
    }



    @Configuration(proxyBeanMethods = false)
    static class Service2Config {
        @Bean
        Service2Bean service2Bean(ClientCommonBean clientCommonBean) {
            return new Service2Bean(clientCommonBean);
        }
    }
    static class Service2Bean {
        private final ClientCommonBean clientCommonBean;

        Service2Bean(ClientCommonBean clientCommonBean) {
            this.clientCommonBean = clientCommonBean;
        }

        @Override
        public String toString() {
            return "Service2Bean{" +
                    "clientCommonBean=" + clientCommonBean +
                    '}';
        }
    }



    static class TestSpec implements NamedContextFactory.Specification {
        private final String name;
        private final Class<?>[] configurations;

        public TestSpec(String name, Class<?>[] configurations) {
            this.name = name;
            this.configurations = configurations;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Class<?>[] getConfiguration() {
            return configurations;
        }
    }




    static class TestClient extends NamedContextFactory<TestSpec> {

        public TestClient(Class<?> defaultConfigType) {
            /*
            String propertySourceName  属性源名称：客户端名称 testClient
			String propertyName  属性名：环境名 test.context.name
             */
            super(defaultConfigType, "testClient", PROPERTY_NAME);
        }
    }

}
