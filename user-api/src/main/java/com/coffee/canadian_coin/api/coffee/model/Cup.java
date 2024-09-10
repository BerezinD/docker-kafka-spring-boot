package com.coffee.canadian_coin.api.coffee.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Cup(@JsonProperty("size") CupSize size, @JsonProperty("type") String type,
                  Beverage beverage) {

  public Cup {
    if (size == null) {
      throw new IllegalArgumentException("Size cannot be null or blank");
    }
  }
}
