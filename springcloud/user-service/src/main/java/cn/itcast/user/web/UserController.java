package cn.itcast.user.web;

import cn.itcast.pojo.response.UserResponse;
import cn.itcast.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public UserResponse getUserById(@PathVariable("id") Long id){
        return messageService.findUserById(id);
    }
}
