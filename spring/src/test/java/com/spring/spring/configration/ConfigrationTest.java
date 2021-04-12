package com.spring.spring.configration;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigrationTest {

    /**
     * @Configuration  被该注解标识的类，表明该类是method bean集合的配置文件
     * 有无该注解，method bean都可以交给spring容器
     */
    @org.junit.Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigrationConfig.class);
        System.out.println(context.getBean("user"));
    }


    /**
     * 1、有@Configration时，输出的user bean地址一样，说明都是从容器中获取的
     * 2、无@Configration时，输出的user bean地址不一样，说明在new UserService(user())时，直接创建出来新的user,
     *    而不是从容器中获取的。
     */
    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigrationConfig.class);
        System.out.println(context.getBean("user"));
    }
}
