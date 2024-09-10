package com.coffee.canadian_coin.api.coffee.model;

public record Beverage(String name, String description, long priceInCents) {

  public Beverage {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or blank");
    }
    if (priceInCents <= 0) {
      throw new IllegalArgumentException("Price must be greater than 0");
    }
  }
}
