package com.varun.ordermicroservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer orderId;
    private List<FoodItemsDto> foodItemsDtoList;
    private Restaurant restaurant;
    private UserDto userDto;
}
