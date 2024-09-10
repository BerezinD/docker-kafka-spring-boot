package com.coffee.model;

public record Cup(String size, String type, Beverage beverage) {

  public Cup {
    if (size == null) {
      throw new IllegalArgumentException("Size cannot be null or blank");
    }
  }
}
