//package com.tc.event.reactor.mongo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.aa.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
///**
// * @Description webflux（底层基于reactor）+Mongodb(反应式nosqlDb,目前sql数据库还没有支持)  增删改查
// * @Author Administrator
// * @DATE 2019/4/4 16:37
// * @Version 1.0
// **/
//@Controller
//@RequestMapping("/city")
//public class CityWebFluxController {
//    @Autowired
//    private CityService cityService;
//
//    @PostMapping
//    @ResponseBody
//    public Mono<City> saveCity(@RequestBody City city){
//        return cityService.saveCity(city);
//    }
//
//    @GetMapping("/{id}")
//    @ResponseBody
//    public Mono<City> findCityById(@PathVariable("id") String id){
//        return cityService.findCityById(id);
//    }
//
//    @GetMapping
//    @ResponseBody
//    public Flux<City> findAllCity(){
//        Flux<City> cityFlux = cityService.findAllCity();
//        return cityFlux;
//    }
//
//    @PutMapping
//    @ResponseBody
//    public Mono<City> modifyCity(@RequestBody City city){
//        return cityService.modifyCity(city);
//    }
//
//    @DeleteMapping
//    @ResponseBody
//    public Mono<String> deleteCity(@RequestParam(value = "id",required = false) String id){
//        City city = new City();
//        city.setId(id);
//        return cityService.deleteCity(city);
//    }
//}
