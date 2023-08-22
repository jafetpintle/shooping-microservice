package japy.shoopingmicroservice.controller;


import japy.shoopingmicroservice.persistence.dto.OrderDto;
import japy.shoopingmicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {
    private final OrderService orderService;
    @Autowired
    public ShoppingController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public String saveOrder(@RequestBody OrderDto orderDto){

        this.orderService.saveOrder(orderDto);

        return "Order saved";
    }
}
