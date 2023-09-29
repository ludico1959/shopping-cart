package ifrs.tads.shoppingcart.dtos;

import ifrs.tads.shoppingcart.entities.User;
import jakarta.validation.constraints.NotNull;

public record OrderCreateDTO(
  
  @NotNull
  User user

) {}
