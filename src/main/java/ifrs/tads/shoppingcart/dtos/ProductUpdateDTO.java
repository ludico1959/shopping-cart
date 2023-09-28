package ifrs.tads.shoppingcart.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProductUpdateDTO(
  @NotBlank
  String id,

  String name,
  float price,
  int stock,

  @Pattern(regexp = "\\d{2}")
  String stateStorage
) {}
