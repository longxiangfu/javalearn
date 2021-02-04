package com.tc.event.reactor.webflux.web;

import com.tc.common.ResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orderClient")
public class OrderControllerClient {

    WebClient webClient;

    public OrderControllerClient(WebClient.Builder builder){
        this.webClient = builder.build();
    }


    @PostMapping("/add1")
    public void add1(){
        System.out.println("subscribe前线程：" + Thread.currentThread().getName());
        System.out.println("添加第一条数据");
        Order order = new Order();
        order.setOrderSn("202012270000");
        order.setMemberId(1111L);
        order.setStatus(1);
        Mono<ResponseDTO> responseEntityMono = webClient
                .post()
                .uri("http://localhost:8081/eventNotify/order/add")
                .contentType(MediaType.APPLICATION_JSON)//表示以json的形式传到服务端，默认   MediaType.APPLICATION_STREAM_JSON表示以流的形式传到服务端，即流元素是一个一个传出的
                .body(Mono.just(order), Order.class)
                .retrieve()
                .bodyToMono(ResponseDTO.class);
        responseEntityMono.subscribe(System.out::println);
    }


    @GetMapping("findOne")
    public void findOne(){
        System.out.println("查询一条数据");
        Mono<ResponseDTO> responseEntityMono = webClient
                .get()
                .uri("http://localhost:8081/eventNotify/order/getById?id={id}", 70)
                .retrieve()
                .bodyToMono(ResponseDTO.class);
        responseEntityMono.subscribe(System.out::println);
    }


    @GetMapping("/add2")
    public void add2(){
        System.out.println("添加第二条数据");
        Order order = new Order();
        order.setOrderSn("202012270001");
        order.setMemberId(2222L);
        order.setStatus(0);
        Mono<ResponseDTO> responseEntityMono = webClient
                .post()
                .uri("http://localhost:8081/eventNotify/order/add")
                .body(Mono.just(order), Order.class)
                .retrieve()
                .bodyToMono(ResponseDTO.class);
        responseEntityMono.subscribe(System.out::println);
    }

    @GetMapping("/list")
    public void list(){
        Mono<ResponseDTO> responseEntityMono = webClient
                .get()
                .uri("http://localhost:8081/eventNotify/order/list")
                .retrieve()
                .bodyToMono(ResponseDTO.class);
        responseEntityMono.subscribe(System.out::println);
    }


    @PostMapping("/delete")
    public void delete(){
        Mono<ResponseDTO> responseEntityMono = webClient
                .delete()
                .uri("http://localhost:8081/eventNotify/order/deleteById?id={id}", 71)
                .retrieve()
                .bodyToMono(ResponseDTO.class);
        responseEntityMono.subscribe(System.out::println);
    }


    @PostMapping("/update")
    public void update(){
        Order order = new Order();
        order.setId(72L);
        order.setStatus(0);
        Mono<ResponseDTO> responseEntityMono = webClient
                .post()
                .uri("http://localhost:8081/eventNotify/order/update")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(order), Order.class)
                .retrieve()
                .bodyToMono(ResponseDTO.class);
        responseEntityMono.subscribe(System.out::println);
    }

}
