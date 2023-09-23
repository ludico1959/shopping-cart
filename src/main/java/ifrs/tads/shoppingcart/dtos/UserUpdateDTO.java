package ifrs.tads.shoppingcart.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO(
  @NotBlank
  String id,
  
  String name,
  String email,
  String password,
  ShortAddressDTO addressInfo
) {}
