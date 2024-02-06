package com.varun.ordermicroservice.service;

import com.varun.ordermicroservice.Dto.OrderDto;
import com.varun.ordermicroservice.Dto.OrderDtoFromFrontEnd;
import com.varun.ordermicroservice.Dto.UserDto;
import com.varun.ordermicroservice.entity.Order;
import com.varun.ordermicroservice.mapper.OrderMapper;
import com.varun.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderSequenceService orderSequenceService;

    @Autowired
    private RestTemplate restTemplate;
    public OrderDto create(OrderDtoFromFrontEnd orderDto) {
        Order orderInitial = new Order();
        orderInitial.setOrderId(orderSequenceService.getOrderSequence());
        orderInitial.setUserDto(fetchUserDetailsWithUserId(orderDto.getUserId()));
        orderInitial.setRestaurant(orderDto.getRestaurant());
        orderInitial.setFoodItemsDtoList(orderDto.getFoodItemsDtoList());
        Order order = orderRepository.save(orderInitial);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(order);
    }

    private UserDto fetchUserDetailsWithUserId(Integer userId) {
        UserDto userDto =  restTemplate.getForObject("http://USER-SERVICE/user/getUserById/"+userId,UserDto.class);
        return userDto;
    }
}
