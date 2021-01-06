package com.spring.spring.ioc;

import com.spring.spring.ioc.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configureation + @Bean的方式创建Bean
 */
@Configuration
public class AppConfig {

    @Bean
    public UserService userService(){
        return new UserService();
    }
}
