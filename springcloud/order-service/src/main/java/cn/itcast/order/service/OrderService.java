package cn.itcast.order.service;

import cn.itcast.pojo.response.OrderResponse;

public interface OrderService {

    OrderResponse findOrderById(Long orderId);
}
