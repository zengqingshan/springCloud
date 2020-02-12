package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;

@RestController
public class UserController {
    /**
     * 报错：Could not autowire. There is more than one bean of 'EurekaClient' type.
     */
//  @Autowired
//  private EurekaClient discoveryClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.findOne(id);
    }

    @RequestMapping("/instance-info")
    public ServiceInstance getServiceUrl() {
        ServiceInstance serviceInstance = this.discoveryClient.getLocalServiceInstance();
        return serviceInstance;
    }
}
