package cn.itcast.service;


import cn.itcast.pojo.response.UserResponse;

public interface MessageService {

    UserResponse findUserById(Long userId);
}
