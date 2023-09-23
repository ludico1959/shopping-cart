package ifrs.tads.shoppingcart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifrs.tads.shoppingcart.dtos.UserDTO;
import ifrs.tads.shoppingcart.entities.Address;
import ifrs.tads.shoppingcart.entities.User;
import ifrs.tads.shoppingcart.repositories.UserRepository;

@Service
public class UserService {
  @Autowired //injeção de dependência
  private UserRepository repository;

  @Autowired
  private AddressService addressService;

  public void create(UserDTO userData) {
    Address address = this.addressService.create(userData.addressInfo());

    this.repository.save(new User(userData, address));
  }

  public List<User> list() {
    return this.repository.findAll();
  }
}
