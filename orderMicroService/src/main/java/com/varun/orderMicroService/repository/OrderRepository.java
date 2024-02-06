package com.varun.ordermicroservice.repository;

import com.varun.ordermicroservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,Integer> {
}
