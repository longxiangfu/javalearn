package com.tc.hutoolTest.spring;

import cn.hutool.extra.spring.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class SpringUtilTest {

    @GetMapping("/test")
    public void test() {
        Demo demo = SpringUtil.getBean("testDemo");
        System.out.println(demo); // Demo(id=1, name=demo)
    }
}
