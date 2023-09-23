package ifrs.tads.shoppingcart.dtos;

import jakarta.validation.constraints.NotBlank;

public record ShortAddressDTO(
  String id,

  @NotBlank
  String zipCode,

  @NotBlank
  String number,

  @NotBlank
  String complement
) {}