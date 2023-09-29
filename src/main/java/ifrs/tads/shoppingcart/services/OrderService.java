package ifrs.tads.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifrs.tads.shoppingcart.dtos.OrderCreateDTO;

import ifrs.tads.shoppingcart.entities.Order;
import ifrs.tads.shoppingcart.repositories.postgresql.OrderRepository;

@Service
public class OrderService {
  
  @Autowired
  private OrderRepository repository;

  public Order create(OrderCreateDTO orderData) {

    Order order = this.repository.save(new Order(orderData));

    return order;

  }

}
