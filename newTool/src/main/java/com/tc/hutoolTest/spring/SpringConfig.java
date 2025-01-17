package com.tc.hutoolTest.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(name = "testDemo")
    public Demo generateDemo() {
        Demo demo = new Demo();
        demo.setId(1L);
        demo.setName("demo");
        return demo;
    }

}
