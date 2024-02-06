package com.varun.ordermicroservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFromFrontEnd {
    List<FoodItemsDto> foodItemsDtoList;
    Restaurant restaurant;
    private Integer userId;
}
