package ifrs.tads.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ifrs.tads.shoppingcart.dtos.UserCreateDTO;
import ifrs.tads.shoppingcart.dtos.UserProjectionDTO;
import ifrs.tads.shoppingcart.dtos.UserUpdateDTO;
import ifrs.tads.shoppingcart.entities.Address;
import ifrs.tads.shoppingcart.entities.User;
import ifrs.tads.shoppingcart.repositories.UserRepository;

@Service
public class UserService {
  @Autowired //injeção de dependência
  private UserRepository repository;

  @Autowired
  private AddressService addressService;

  public void create(UserCreateDTO userData) {
    Address address = this.addressService.create(userData.addressInfo());

    this.repository.save(new User(userData, address));
  }

  public Page<UserProjectionDTO> list() {
    Pageable pageable = PageRequest.of(0, 5, Sort.by("name"));

    return this.repository
      .findAll(pageable)
      .map(UserProjectionDTO::new);
  }

  public void update(UserUpdateDTO userData) {
    Address address = null;

    if (userData.addressInfo() != null) {
      String addressId = this.repository.getReferenceById(userData.id()).getAddress().getId();

      System.out.println("\n\n----------------\n" + addressId + "\n----------------\n\n");

      address = this.addressService.update(userData.addressInfo(), addressId);
    }
    System.out.println("\n\n----------------\n" + address + "\n----------------\n\n");

    User user = this.repository.getReferenceById(userData.id());

    user.updateInfo(userData, address);
  }
}
