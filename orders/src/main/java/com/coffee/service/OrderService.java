package com.coffee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.coffee.model.Order;
import com.coffee.repository.OrderRepository;

@Service
public class OrderService {
  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> getOrders() {
    return orderRepository.findAll();
  }

  public void saveOrder(Order order) {
    orderRepository.save(order);
  }

}
