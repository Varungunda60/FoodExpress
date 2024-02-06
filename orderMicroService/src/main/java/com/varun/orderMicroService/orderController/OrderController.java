package com.varun.orderMicroService.orderController;

import com.varun.orderMicroService.dto.OrderDto;
import com.varun.orderMicroService.dto.OrderDtoFromFrontEnd;
import com.varun.orderMicroService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    private ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFrontEnd orderDtoFromFrontEnd){
        return orderService.saveOrder(orderDtoFromFrontEnd);
    }
}
