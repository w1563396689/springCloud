package cn.itcast.order.service;

import cn.itcast.order.pojo.response.OrderResponse;

public interface OrderService {

    OrderResponse findOrderById(Long orderId);
}
