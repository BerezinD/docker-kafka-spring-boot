package com.coffee.canadian_coin.api.coffee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.coffee.canadian_coin.api.coffee.model.Beverage;
import com.coffee.canadian_coin.api.coffee.model.Cup;
import com.coffee.canadian_coin.api.coffee.model.CupSize;
import com.coffee.canadian_coin.api.coffee.model.RequestBuyCoffee;
import com.coffee.canadian_coin.api.coffee.service.CoffeeService;

@RestController
public class CoffeeController {

  private final CoffeeService coffeeService;

  public CoffeeController(CoffeeService coffeeService) {
    this.coffeeService = coffeeService;
  }

  @GetMapping("/coffee")
  public ResponseEntity<List<Beverage>> getAllCoffeeTypes() {
    return ResponseEntity.ok(coffeeService.getAllCoffeeTypes());
  }

  @GetMapping("/coffee/cup-sizes")
  public ResponseEntity<List<CupSize>> getAllCoffeeCupSizes() {
    return ResponseEntity.ok(coffeeService.getAllCoffeeCupSizes());
  }

  @PostMapping("/coffee/buy")
  public ResponseEntity<Cup> buyCupOfCoffee(@RequestBody RequestBuyCoffee request) {
    return ResponseEntity.ok(coffeeService.buyCupOfCoffee(request.cupSize(), request.cupType(), request.beverageName()));
  }

}
