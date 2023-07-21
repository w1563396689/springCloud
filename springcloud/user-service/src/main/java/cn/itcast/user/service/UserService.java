package cn.itcast.user.service;

import cn.itcast.user.pojo.User;

public interface UserService {

    User findUserById(Long id);
}
