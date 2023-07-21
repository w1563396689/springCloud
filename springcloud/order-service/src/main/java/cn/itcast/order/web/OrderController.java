package cn.itcast.order.web;

import cn.itcast.order.pojo.entity.Order;
import cn.itcast.order.pojo.response.OrderResponse;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public OrderResponse queryOrderByOrderId(@PathVariable("id") Long orderId) {
       return orderService.findOrderById(orderId);
    }
}
