package com.varun.foodCatalouge.repository;

import com.varun.foodCatalouge.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
//    List<FoodItem> findAllByRestaurantId(Integer restaurantId);

    List<FoodItem> findByRestaurantId(Integer restaurantId);
}
