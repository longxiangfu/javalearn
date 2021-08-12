package com.spring.spring.di.resource;

import com.spring.spring.di.Svc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 1. 同时指定了name和type,则按name和type严格匹配
 * 2. 只指定了name, 则按name匹配
 * 3. 只指定了type, 则按type匹配，若找到多个bean，则抛出异常
 * 4. 没有指定name和type,先通过byName进行匹配，即按变量名进行匹配
 * 5. 没有指定name和type,并且byName也没有匹配上，则通过byType进行匹配，若找到多个bean,则抛出异常
 */
@RestController
@RequestMapping("/resource")
public class ResourceTest {


    // 1
//    @Resource(name = "svcA", type = Svc.class)
//    private Svc svc;

    // 2
//    @Resource(name = "svcB")
//    private Svc svc;

    // 3
//    @Resource(type = Svc.class)
//    private Svc svc;
//    报错：No qualifying bean of type 'com.spring.spring.di.Svc' available: expected single matching bean but found 3: svcA,svcB,svcC

    // 4
//    @Resource
//    private Svc svcC;

    // 5
//    @Resource
//    private Svc svc;
//    No qualifying bean of type 'com.spring.spring.di.Svc' available: expected single matching bean but found 3: svcA,svcB,svcC



    @GetMapping("/test")
    public void test(){
        // 1
//        svc.sayHello(); // hello,this is service A

        // 2
//        svc.sayHello(); // hello,this is service B

        // 4
//        svcC.sayHello(); // hello,this is service C

        // 5
//        svc.sayHello();

    }
}
