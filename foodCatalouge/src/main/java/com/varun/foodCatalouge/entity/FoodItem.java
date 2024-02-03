package com.varun.foodCatalouge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Long price;
    private Integer restaurantId;
    @NotNull
//    @Column(nullable = false,columnDefinition = "int default 0")
    private Integer quantity;

}

