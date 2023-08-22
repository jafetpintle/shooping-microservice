package japy.shoopingmicroservice.persistence.dto;

import japy.shoopingmicroservice.persistence.entity.OrderItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private List<OrderItemEntity> orderItems;
}
