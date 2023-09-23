package ifrs.tads.shoppingcart.dtos;

import jakarta.validation.constraints.NotBlank;

public record ShortAddressDTO(
  @NotBlank
  String zipCode,

  @NotBlank
  String number,

  @NotBlank
  String complement
) {}