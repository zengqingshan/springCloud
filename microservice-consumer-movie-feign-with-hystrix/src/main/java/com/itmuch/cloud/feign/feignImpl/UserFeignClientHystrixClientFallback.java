package com.itmuch.cloud.feign.feignImpl;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientHystrixClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-3L);
        return user;
    }
}
