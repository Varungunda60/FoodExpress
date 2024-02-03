package com.varun.foodCatalouge.dto;

import com.varun.foodCatalouge.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalougePage {
    Restaurant restaurant;
    List<FoodItemDto> foodItemList;
}
