package com.tc.hutoolTest.spring;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Demo {
    private Long id;
    private String name;

    @Bean(name = "testDemo")
    public Demo generateDemo() {
        Demo demo = new Demo();
        demo.setId(1L);
        demo.setName("demo");
        return demo;
    }


}
