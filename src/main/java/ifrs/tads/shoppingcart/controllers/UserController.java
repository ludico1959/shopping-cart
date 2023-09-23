package ifrs.tads.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifrs.tads.shoppingcart.dtos.UserDTO;
import ifrs.tads.shoppingcart.entities.User;
import ifrs.tads.shoppingcart.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  public void create(@RequestBody @Valid UserDTO userData) {
    this.service.create(userData);
  }

  @GetMapping
  
  public List<User> list() {
    return this.service.list();
  }

}
