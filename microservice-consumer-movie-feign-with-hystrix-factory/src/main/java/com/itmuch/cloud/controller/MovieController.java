package com.itmuch.cloud.controller;

import com.itmuch.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/movie/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }
}
