package ifrs.tads.shoppingcart.dtos;

import ifrs.tads.shoppingcart.entities.Address;
import ifrs.tads.shoppingcart.entities.User;

public record UserProjectionDTO(
  String name,
  String email,
  Address address
) {

  public UserProjectionDTO(User user) {
    this(user.getName(), user.getEmail(), user.getAddress());
  }

}
