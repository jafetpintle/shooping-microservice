package japy.shoopingmicroservice.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import japy.shoopingmicroservice.Client.StockClient;
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
    private final StockClient stockClient;

    @Autowired
    public ShoppingController(OrderService orderService, StockClient stockClient) {
        this.orderService = orderService;
        this.stockClient = stockClient;
    }

    @PostMapping("/order")
    @HystrixCommand(fallbackMethod = "fallbackToStockService")
    public String saveOrder(@RequestBody OrderDto orderDto){
        boolean inStock = orderDto.getOrderItems().stream()
                .allMatch(orderItem -> stockClient.stockAvaible(orderItem.getCode()));
        if(inStock){
            this.orderService.saveOrder(orderDto);
            return "Order saved";
        }

        return "Order cannot be saved";
    }

    private String fallbackToStockService(){
        return "Something went wrong. Please try after some time";
    }
}
