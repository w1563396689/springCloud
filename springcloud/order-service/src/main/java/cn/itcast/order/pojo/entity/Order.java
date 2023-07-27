package cn.itcast.order.pojo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
}
