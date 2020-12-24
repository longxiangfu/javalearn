package com.tc.event.reactor.webflux.web;

import com.tc.common.ResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    OrderRepository orderRepository;


    public Mono<ResponseDTO<Order>> findById(Long id){
        return Mono.just(orderRepository.getById(id))
                .switchIfEmpty(Mono.error(new RuntimeException("根据id查询不到对应数据")))
                .map(order -> ResponseDTO.Factory.ok(order));
    }

    public Mono<ResponseDTO> save(Order order) {
        orderRepository.save(order);
        return Mono.just(ResponseDTO.Factory.ok());
    }


    public Mono<ResponseDTO<List<Order>>> getListByIdList(List<Long> idList){
        return Flux.fromIterable(orderRepository.getListByIdList(idList))
                .switchIfEmpty(Mono.error(new RuntimeException("根据id集合查询不到对应数据")))
                .map(e -> {
                    e.setStatus(10);
                    return e;
                })
                .collectList()
                .map(list -> ResponseDTO.Factory.ok(list))
                ;
    }


    public Mono<ResponseDTO> deleteById(Long id){
        orderRepository.deleteById(id);
        return Mono.just(ResponseDTO.Factory.ok());
    }

    public Mono<ResponseDTO> updateStatusById(Integer status, Long id){
        orderRepository.updateStatusById(status, id);
        return Mono.just(ResponseDTO.Factory.ok());
    }


}
