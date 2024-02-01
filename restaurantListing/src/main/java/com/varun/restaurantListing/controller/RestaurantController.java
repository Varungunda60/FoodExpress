package com.varun.restaurantListing.controller;

import com.varun.restaurantListing.dto.RestaurantDto;
import com.varun.restaurantListing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant" )
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        List<RestaurantDto> allRestaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @GetMapping("/getRestaurantById/{Id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Integer Id){
        return restaurantService.getRestaurantById(Id);
    }

    @PostMapping("/create")
    public  ResponseEntity<RestaurantDto> create(@RequestBody RestaurantDto restaurantDto){
        RestaurantDto restauranAdded = restaurantService.addRestaurant(restaurantDto);
        return new ResponseEntity<>(restauranAdded,HttpStatus.CREATED);
    }
}

