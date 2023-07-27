package cn.itcast.user.service.impl;

import cn.itcast.user.conf.UserProperties;
import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
//@RefreshScope  可以实现配置的热部署
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserProperties userProperties;

//    @Value("${byd.logintemplate}")
//    private String loginTemplateId;

    @Override
    public User findUserById(Long id) {
        System.out.println("login: " + userProperties);
        return userMapper.findUserById(id);
    }
}
