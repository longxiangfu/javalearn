package com.tc.event;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Resource
    OrderRepository repository;

    public void insert() {
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setId(1L);
        order.setOrderSn("111111");
        order.setMemberId(100L);
        order.setCreateTime(new Date());
        order.setStatus(1);
        orderList.add(order);

        Order order1 = new Order();
        order1.setId(2L);
        order1.setOrderSn("222222");
        order1.setMemberId(101L);
        order1.setCreateTime(new Date());
        order1.setStatus(1);
        orderList.add(order1);

        Order order2 = new Order();
        order2.setId(3L);
        order2.setOrderSn("333333");
        order2.setMemberId(102L);
        order2.setCreateTime(new Date());
        order2.setStatus(1);
        orderList.add(order2);

        Order order3 = new Order();
        order3.setId(4L);
        order3.setOrderSn("444444");
        order3.setMemberId(103L);
        order3.setCreateTime(new Date());
        order3.setStatus(1);
        orderList.add(order3);
        repository.saveAll(orderList);

    }

    public void select() {
        Order order = repository.findAllByMemberId(100L);
        System.out.println(order.toString());
        Order order1 = repository.findAllByMemberId(101L);
        System.out.println(order1.toString());
        Order order2 = repository.findAllByMemberId(102L);
        System.out.println(order2.toString());
        Order order3 = repository.findAllByMemberId(103L);
        System.out.println(order3.toString());
    }
}
