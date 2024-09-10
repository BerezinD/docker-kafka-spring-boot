package com.coffee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.coffee.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
