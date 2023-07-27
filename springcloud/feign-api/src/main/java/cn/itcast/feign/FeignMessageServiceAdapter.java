package cn.itcast.feign;


import cn.itcast.feign.config.FeignClientConfiguration;

import cn.itcast.pojo.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice", configuration = FeignClientConfiguration.class)
public interface FeignMessageServiceAdapter {

    @GetMapping(value = "/user/findById/{id}")
    UserResponse findUserById(@PathVariable(value = "id") Long id);
}
