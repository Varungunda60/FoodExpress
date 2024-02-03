package com.varun.foodCatalouge.controller;

import com.varun.foodCatalouge.dto.FoodCatalougePage;
import com.varun.foodCatalouge.dto.FoodItemDto;
import com.varun.foodCatalouge.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    private FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto foodItemInDb = foodCatalogueService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(foodItemInDb, HttpStatus.CREATED);
    }
    @GetMapping("/getRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCatalougePage> getRestaurantAndFoodItemsById(@PathVariable Integer restaurantId){
        FoodCatalougePage foodCatalougePage = foodCatalogueService.getRestaurantAndFoodItemsById(restaurantId);
        return new ResponseEntity<>(foodCatalougePage,HttpStatus.OK);
    }

}
