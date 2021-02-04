package com.spring.spring.ioc.bean;


import org.springframework.stereotype.Component;

@Component
public class People {
    private XiaoMing xiaoMing;
//    @Autowired
//    private XiaoMing xiaoMing;

    /**
     * 构造器注入
     * @param xiaoMing
     */
    public People(XiaoMing xiaoMing){
        System.out.println("People中的XiaoMing" + xiaoMing);
        System.out.println("People的有参构造器");
    }
//    public People(){
//        System.out.println("People的有参构造器");
//    }
}
