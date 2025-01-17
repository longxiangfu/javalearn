package com.springboot.test;

import com.springboot.web.IndexServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class Test {
    public static void main(String[] args) throws LifecycleException, ServletException {
        /*
        测试内嵌tomcat原理
         */
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8081);
//        tomcat.start();
//
//        // addWebapp让当前项目变成web项目
//        Context context = tomcat.addWebapp("/boot", "I:\\workspace-lxf\\");
//        IndexServlet indexServlet = new IndexServlet();
//        tomcat.addServlet("/boot", "index", indexServlet); // 将自定义Servlet注册到tomcat中
//        context.addServletMappingDecoded("/index", "index"); // 路径和Servlet映射
//
//        System.out.println("tomcat启动完成");
//        tomcat.getServer().await();


    }
}
