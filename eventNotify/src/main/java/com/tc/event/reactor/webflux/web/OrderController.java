package com.tc.event.reactor.webflux.web;

import com.tc.common.ResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 响应式编程 Webflux
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService service;


    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)//配合客户端 默认
    public Mono<ResponseDTO> add(@RequestBody Order order){
        return service.save(order);
    }


    @GetMapping("/getById")
    public Mono<ResponseDTO<Order>> getById(@RequestParam("id") Long id){
        return service.findById(id);
    }


    @GetMapping("/list")
    protected Mono<ResponseDTO<List<Order>>> list(){
        List<Long> idList = new ArrayList<>();
        idList.add(70L);
        idList.add(71L);
        idList.add(72L);
        return service.getListByIdList(idList);
    }


    @DeleteMapping("/deleteById")
    public Mono<ResponseDTO> deleteById(@RequestParam("id") Long id){
        return service.deleteById(id);
    }

    @PostMapping("/update")
    public Mono<ResponseDTO> update(@RequestBody Order order){
        return service.updateStatusById(order.getStatus(), order.getId());
    }

    @PostMapping("/testAndroid")
    public void testAndroid(@RequestBody Order order){
        System.out.println("服务端收到了：" + order.toString());
    }

}
