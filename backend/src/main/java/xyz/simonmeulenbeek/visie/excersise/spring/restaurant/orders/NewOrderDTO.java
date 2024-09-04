package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders;

import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems.OrderItemDTO;

import java.util.List;

public class NewOrderDTO {
    public String sessionId;
    public List<OrderItemDTO> orderItems;
}
