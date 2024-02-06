package com.varun.ordermicroservice.controller;

import com.varun.ordermicroservice.Dto.OrderDto;
import com.varun.ordermicroservice.Dto.OrderDtoFromFrontEnd;
import com.varun.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order" )
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDto> create(@RequestBody OrderDtoFromFrontEnd orderDtoFE){
        OrderDto orderDto = orderService.create(orderDtoFE);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
