package ifrs.tads.shoppingcart.dtos;

import ifrs.tads.shoppingcart.entities.Order;
import ifrs.tads.shoppingcart.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemCreateDTO(
  @NotBlank
  int amount,

  @NotNull
  Product product,

  @NotNull
  Order order
) {}
