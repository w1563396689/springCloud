package cn.itcast.order.service.impl;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.entity.Order;
import cn.itcast.order.service.OrderService;
import cn.itcast.pojo.response.OrderResponse;
import cn.itcast.pojo.response.UserResponse;
import cn.itcast.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这里直接引入会有循环依赖的问题，老网贷的解决办法是cc-prj-api中放所有的request，response，ccMessageservice
     * ccfeign 中引入cc-prj-api的包， cc-prj-boot中引入ccfeign,cc-prj-api 这样就可以避免循环依赖问题
     * @param orderId
     * @return
     */
    @Autowired
    private MessageService messageService;


//    @Override
//    public OrderResponse findOrderById(Long orderId) {
//
//        Order anOrder = orderMapper.findById(orderId);
//        OrderResponse orderResponse = new OrderResponse();
//        BeanUtils.copyProperties(anOrder, orderResponse);
//        // 使用http请求 post请求示例:  postForObject(url, request, response.class)
//        UserResponse userResponse = restTemplate.getForObject("http://userservice/user/findById/" + anOrder.getUserId(), UserResponse.class);
//        orderResponse.setUserResponse(userResponse);
//        return orderResponse;
//    }

    @Override
    public OrderResponse findOrderById(Long orderId) {

        Order anOrder = orderMapper.findById(orderId);
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(anOrder, orderResponse);
        UserResponse userResponse = messageService.findUserById(anOrder.getUserId());
        orderResponse.setUserResponse(userResponse);
        return orderResponse;
    }
}
