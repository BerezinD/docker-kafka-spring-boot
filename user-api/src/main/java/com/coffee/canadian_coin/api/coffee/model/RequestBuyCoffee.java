package com.coffee.canadian_coin.api.coffee.model;

public record RequestBuyCoffee(String cupSize, String cupType, String beverageName) {

  public RequestBuyCoffee {
    if (cupSize == null || cupSize.isBlank()) {
      throw new IllegalArgumentException("Cup size cannot be null or blank");
    }
    if (cupType == null || cupType.isBlank()) {
      throw new IllegalArgumentException("Cup type cannot be null or blank");
    }
    if (beverageName == null || beverageName.isBlank()) {
      throw new IllegalArgumentException("Beverage name cannot be null or blank");
    }
  }
}
