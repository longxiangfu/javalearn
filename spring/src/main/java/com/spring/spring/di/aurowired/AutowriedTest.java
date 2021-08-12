package com.spring.spring.di.aurowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. 按照type在上下文中查找匹配的bean
 * 查找type为Svc的bean
 * 2. 如果有多个bean,则按照name进行匹配
 * （1）如果有@Qualifier，则按照@Qualifier指定的name进行匹配
 * 查找name为svcA和svcB的bean
 * （2）如果没有@Qualifier,则按照变量名进行匹配
 * 查找name为svcA的bean
 * 3. 匹配不到或找到多个则报错
 * 直接编译就会报错
 */
@RestController
@RequestMapping("/autowired")
class AutowriedTest {

    // 1
//    @Autowired
//    @Qualifier("svcA")
//    private Svc svc;


    // 2
//    @Autowired
//    @Qualifier("svcB")
//    private Svc svc;

    // 3
//    @Autowired
//    private Svc svcA;

    // 4 直接编译报错
//    @Autowired
//    private Svc svc;

//    Could not autowire. There is more than one bean of 'Svc' type.
//            Beans:
//    svcA   (SvcA.java)
//    svcB   (SvcB.java)
//    svcC   (SvcC.java)


    @GetMapping("/test")
    public void test(){
        // 1
//        svc.sayHello(); // hello,this is service A


        // 2
//        svc.sayHello(); // hello,this is service B

        // 3
//        svcA.sayHello(); // hello,this is service A
    }

}
