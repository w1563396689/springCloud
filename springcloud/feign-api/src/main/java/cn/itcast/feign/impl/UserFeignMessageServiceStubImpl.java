package cn.itcast.feign.impl;

import cn.itcast.feign.FeignMessageServiceAdapter;
import cn.itcast.pojo.response.UserResponse;
import cn.itcast.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFeignMessageServiceStubImpl implements MessageService {

    @Autowired
    FeignMessageServiceAdapter feignMessageServiceAdapter;

    @Override
    public UserResponse findUserById(Long userId) {
        return feignMessageServiceAdapter.findUserById(userId);
    }
}
