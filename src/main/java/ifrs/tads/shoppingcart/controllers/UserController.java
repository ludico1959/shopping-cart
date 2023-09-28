package ifrs.tads.shoppingcart.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ifrs.tads.shoppingcart.dtos.UserCreateDTO;
import ifrs.tads.shoppingcart.dtos.UserProjectionDTO;
import ifrs.tads.shoppingcart.dtos.UserUpdateDTO;
import ifrs.tads.shoppingcart.entities.User;
import ifrs.tads.shoppingcart.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  @Transactional
  public ResponseEntity<UserProjectionDTO> create(
    @RequestBody @Valid UserCreateDTO userData, UriComponentsBuilder uriComponentsBuilder) {

    User user = this.service.create(userData);
    URI uri = uriComponentsBuilder
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();

    return ResponseEntity.created(uri).body(new UserProjectionDTO(user));
    
  }

  @GetMapping
  public ResponseEntity<Page<UserProjectionDTO>> list() {
    Page<UserProjectionDTO> page = this.service.list();

    return ResponseEntity.ok(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserProjectionDTO> findById(@PathVariable String id) {
    User user = this.service.findById(id);

    return ResponseEntity.ok(new UserProjectionDTO(user));
  }

  @PutMapping
  @Transactional
  public ResponseEntity<UserProjectionDTO> update(@RequestBody UserUpdateDTO userData) {
    User user = this.service.update(userData);

    return ResponseEntity.ok(new UserProjectionDTO(user));
  } 

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<String> delete(@PathVariable String id) {
    this.service.delete(id);

    return ResponseEntity.noContent().build();
  }

}
