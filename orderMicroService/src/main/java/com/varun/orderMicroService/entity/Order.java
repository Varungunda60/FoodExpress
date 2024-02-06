package com.varun.ordermicroservice.entity;

import com.varun.ordermicroservice.Dto.FoodItemsDto;
import com.varun.ordermicroservice.Dto.Restaurant;
import com.varun.ordermicroservice.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order")
public class Order {
    @Id
    private Integer orderId;
    private List<FoodItemsDto> foodItemsDtoList;
    private Restaurant restaurant;
    private UserDto userDto;
}
