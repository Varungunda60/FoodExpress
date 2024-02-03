package com.varun.foodCatalouge.mapper;

import com.varun.foodCatalouge.dto.FoodItemDto;
import com.varun.foodCatalouge.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);

}
