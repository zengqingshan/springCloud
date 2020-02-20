package com.itmuch.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.Resource;

@RestController
@SessionScope
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
//    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @HystrixCommand(fallbackMethod = "findByIdFallback",commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"))
    public User findById(@PathVariable Long id) {
        System.out.println("*******" + Thread.currentThread().getName());
        // http://localhost:7900/simple/
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    public User findByIdFallback(Long id) {
        System.out.println("%%%%%%%" + Thread.currentThread().getName());
        User user = new User();
        user.setId(-1L);
        user.setUsername("xxxx");
        return user;
    }
}
