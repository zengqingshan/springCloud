package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "", url = "http://localhost:8761/")
public interface FeignEurekaClient {
    @RequestMapping(value = "/eureka/spps/{serviceName}")
    public String findEurekaByServiceNam(@PathVariable("serviceName") String serviceName);
}
