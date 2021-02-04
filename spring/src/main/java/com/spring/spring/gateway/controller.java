package com.spring.spring.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class controller {

    @GetMapping("/{id}")
    public User test(Long id){
        User user = new User();
        user.setId(1L);
        user.setName("龙相甫");
        return user;
    }

}
