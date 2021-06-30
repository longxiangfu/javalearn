package com.spring.springboot.importExample;

import org.springframework.context.annotation.Configuration;

/**
 * redis配置类
 */
@Configuration
@LxfEnableAutoConfiguration
public class ImportConfig {
    // 未配置@Bean,而是采用自定义注解+@Import的方式进行BeanDefinition的装配
}
