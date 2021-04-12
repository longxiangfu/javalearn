package com.springboot.app;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class SpringApplication {

    public static void run() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);
        // 当前项目必须是web项目，才会去读取Servlet3之后标准规定的当前项目或引入的jar包（例如spring web）
        //下META-INF/services/javax.servlet.ServletContainerInitializer的文件，调用文件中配置的实现类
        //ServletContainerInitializer的onStartup方法，该方法的入参是一个集合，该集合包含了
        //WebApplicationInitializer的实现类
        tomcat.addWebapp("/boot", "I:\\workspace-lxf\\");
        tomcat.start();
        tomcat.getServer().await();
    }
}
