package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.feignImpl.UserFeignClientHystrixClientFallback;
import com.itmuch.config.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class,fallback = UserFeignClientHystrixClientFallback.class)
public interface UserFeignClient {
    //    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    @RequestLine("Get /simple/{id}")
    public User findById(@Param("id") Long id);
}
