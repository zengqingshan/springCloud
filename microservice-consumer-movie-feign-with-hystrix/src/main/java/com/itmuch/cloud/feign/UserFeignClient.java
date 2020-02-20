package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.feignImpl.UserFeignClientHystrixClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientHystrixClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

//    static class hystrixClientFallback implements UserFeignClient {
//        public User findById(@PathVariable("id") Long id) {
//            User user = new User();
//            user.setId(-2L);
//            return user;
//        }
//    }
}
