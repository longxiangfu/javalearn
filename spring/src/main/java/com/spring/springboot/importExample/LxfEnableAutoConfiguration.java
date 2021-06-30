package com.spring.springboot.importExample;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(value = ImportA.class)
//@Import(value = ImportBImportBeanDefinitionRegistrar.class)
@Import(value = ImportCImportSelector.class)
public @interface LxfEnableAutoConfiguration {
}
