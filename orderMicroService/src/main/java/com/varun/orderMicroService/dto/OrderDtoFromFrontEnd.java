package com.varun.orderMicroService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private List<FoodItemDto> foodItemDtoList;
    private Integer userId;
    private RestaurantDto restaurantDto;

}
