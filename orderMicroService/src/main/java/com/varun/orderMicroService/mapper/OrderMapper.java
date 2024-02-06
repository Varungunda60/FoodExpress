package com.varun.ordermicroservice.mapper;

import com.varun.ordermicroservice.Dto.OrderDto;
import com.varun.ordermicroservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDtoToOrder(OrderDto order);

    OrderDto mapOrderToOrderDto(Order order);

}
