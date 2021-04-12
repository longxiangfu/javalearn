package com.tc.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order/aa.test")
public class OrderController {

    @Resource
    OrderService orderService;


    /**
     * 测试按照配置插入数据库表
     */
    @GetMapping("/insert")
    public void insert(){
        orderService.insert();
    }


    /**
     * 测试按照配置从数据库表中查询
     */
    @GetMapping("/select")
    public void select(){
        orderService.select();
    }

}
