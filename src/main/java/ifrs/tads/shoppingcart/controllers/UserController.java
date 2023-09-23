package ifrs.tads.shoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifrs.tads.shoppingcart.dtos.UserCreateDTO;
import ifrs.tads.shoppingcart.dtos.UserProjectionDTO;
import ifrs.tads.shoppingcart.dtos.UserUpdateDTO;
import ifrs.tads.shoppingcart.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  @Transactional
  public void create(@RequestBody @Valid UserCreateDTO userData) {
    this.service.create(userData);
  }

  @GetMapping
  public Page<UserProjectionDTO> list() {
    return this.service.list();
  }

  @PutMapping
  @Transactional
  public void uodate(@RequestBody UserUpdateDTO userData) {
    this.service.update(userData);
  } 

}
