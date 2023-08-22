package japy.shoopingmicroservice.service;


import japy.shoopingmicroservice.persistence.dto.OrderDto;
import japy.shoopingmicroservice.persistence.entity.OrderEntity;
import japy.shoopingmicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public void saveOrder(OrderDto orderDto){
        OrderEntity order = new OrderEntity();

        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderItems(orderDto.getOrderItems());

        orderRepository.save(order);
    }
}
