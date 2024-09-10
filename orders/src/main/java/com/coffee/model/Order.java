package com.coffee.model;

import org.springframework.data.annotation.Id;

public class Order {
  @Id
  private String id;
  private String name;
  private String coffeeType;
  private String size;
  private String status;

  public Order() {
  }

  public Order(String name, String coffeeType, String size, String status) {
    this.name = name;
    this.coffeeType = coffeeType;
    this.size = size;
    this.status = status;
  }

}
