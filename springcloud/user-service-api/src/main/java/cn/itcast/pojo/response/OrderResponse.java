package cn.itcast.pojo.response;

import lombok.Data;

@Data
public class OrderResponse{

    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private UserResponse userResponse;
}
