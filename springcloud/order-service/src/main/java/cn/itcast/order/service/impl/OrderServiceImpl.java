package cn.itcast.order.service.impl;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.entity.Order;
import cn.itcast.order.pojo.response.OrderResponse;
import cn.itcast.order.pojo.response.UserResponse;
import cn.itcast.order.service.OrderService;
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

    @Override
    public OrderResponse findOrderById(Long orderId) {

        Order anOrder = orderMapper.findById(orderId);
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(anOrder, orderResponse);
        // 使用http请求 post请求示例:  postForObject(url, request, response.class)
        UserResponse userResponse = restTemplate.getForObject("http://userservice/user/findById/" + anOrder.getUserId(), UserResponse.class);
        orderResponse.setUserResponse(userResponse);
        return orderResponse;
    }
}
