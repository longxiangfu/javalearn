package com.spring.spring.ioc;

import com.spring.spring.ioc.coreExt.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
//@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan("com.spring.spring")
public class AppConfig {

//    @Bean
//    public UserService userService(){
//        return new UserService();
//    }
}
