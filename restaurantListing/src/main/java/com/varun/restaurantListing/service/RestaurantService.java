package com.varun.restaurantListing.service;

import com.varun.restaurantListing.dto.RestaurantDto;
import com.varun.restaurantListing.entity.Restaurant;
import com.varun.restaurantListing.mapper.RestaurantMapper;
import com.varun.restaurantListing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).toList();
    }

    public ResponseEntity<RestaurantDto> getRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()) {
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
        Restaurant restaurantAdded = restaurantRepository.save(restaurant);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantAdded);
    }
}
