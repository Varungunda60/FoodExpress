package com.varun.foodCatalouge.service;

import com.varun.foodCatalouge.dto.FoodCatalougePage;
import com.varun.foodCatalouge.dto.FoodItemDto;
import com.varun.foodCatalouge.dto.Restaurant;
import com.varun.foodCatalouge.entity.FoodItem;
import com.varun.foodCatalouge.mapper.FoodItemMapper;
import com.varun.foodCatalouge.repository.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {
    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    private RestTemplate restTemplate;
    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItem = FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto);
        foodItem = foodItemRepo.save(foodItem);
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem);
//        return null;
    }

    public FoodCatalougePage getRestaurantAndFoodItemsById(Integer restaurantId) {
        List<FoodItemDto> foodItemList;
        foodItemList = fetchFoodItemsListByRestaurantId(restaurantId);
        Restaurant restaurant=fetchRestaurantDetails(restaurantId);
        return createFoodCatalougePage(foodItemList,restaurant);
    }

    private FoodCatalougePage createFoodCatalougePage(List<FoodItemDto> foodItemList, Restaurant restaurant) {
        FoodCatalougePage foodCatalougePage = new FoodCatalougePage();
        foodCatalougePage.setFoodItemList(foodItemList);
        foodCatalougePage.setRestaurant(restaurant);
        return foodCatalougePage;
    }

    private Restaurant fetchRestaurantDetails(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/getRestaurantById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItemDto> fetchFoodItemsListByRestaurantId(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId).stream().map(FoodItemMapper.INSTANCE::mapFoodItemToFoodItemDto).toList();
    }
}
