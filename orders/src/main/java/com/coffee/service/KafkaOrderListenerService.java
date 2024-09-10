package com.coffee.service;

import java.util.UUID;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.coffee.model.Cup;
import com.coffee.model.Order;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaOrderListenerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOrderListenerService.class);

  private final OrderService orderService;

  public KafkaOrderListenerService(OrderService orderService) {
    this.orderService = orderService;
  }

  @KafkaListener(topics = "order", groupId = "canadian-coin-orders")
  public void orderListener(ConsumerRecord<UUID, Cup> consumerRecord) {
    LOGGER.info("Received order: {}", consumerRecord.value());
    Cup cup = consumerRecord.value();
    Order order = new Order(cup.beverage().name(), cup.type(), cup.size(), "IN_PROGRESS");
    orderService.saveOrder(order);
  }
}
