package ifrs.tads.shoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifrs.tads.shoppingcart.dtos.UserDTO;
import ifrs.tads.shoppingcart.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  public void create(@RequestBody UserDTO userData) {
    this.service.create(userData);
  }

}
