package cn.itcast.user.api;

import cn.itcast.pojo.response.UserResponse;
import cn.itcast.service.MessageService;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    UserService userService;

    @Override
    public UserResponse findUserById(Long userId) {
        UserResponse userResponse = new UserResponse();
        User userById = userService.findUserById(userId);
        BeanUtils.copyProperties(userById, userResponse);
        return userResponse;
    }
}
