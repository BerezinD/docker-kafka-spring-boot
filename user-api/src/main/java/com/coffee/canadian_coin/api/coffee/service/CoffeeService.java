package com.coffee.canadian_coin.api.coffee.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import com.coffee.canadian_coin.api.coffee.model.Beverage;
import com.coffee.canadian_coin.api.coffee.model.Cup;
import com.coffee.canadian_coin.api.coffee.model.CupSize;

@Service
public class CoffeeService {

  @Value("${spring.kafka.topic.name}")
  private String topic;

  private final KafkaTemplate<String, Object> kafkaTemplate;

  List<Beverage> beverages = List.of(
      new Beverage("Latte", "Espresso with steamed milk", 350),
      new Beverage("Cappuccino", "Espresso with steamed milk and foam", 300),
      new Beverage("Americano", "Espresso with water", 200),
      new Beverage("Espresso", "Strong black coffee", 150),
      new Beverage("Macchiato", "Espresso with a dollop of foam", 250)
  );

  public CoffeeService(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public List<Beverage> getAllCoffeeTypes() {
    return beverages;
  }

  public Beverage getCoffeeByType(String name) {
    return beverages.stream()
        .filter(beverage -> beverage.name().equals(name))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid coffee type: " + name));
  }

  public List<CupSize> getAllCoffeeCupSizes() {
    return List.of(CupSize.values());
  }

  public Cup buyCupOfCoffee(String size, String type, String beverageName) {
    Cup cup = new Cup(CupSize.fromString(size), type, getCoffeeByType(beverageName));
    kafkaTemplate.send(topic, UUID.randomUUID().toString(), cup);
    return cup;
  }
}
