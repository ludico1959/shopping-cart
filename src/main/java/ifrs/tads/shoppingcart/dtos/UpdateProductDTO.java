package ifrs.tads.shoppingcart.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UpdateProductDTO(
  @NotBlank
  String id,

  String name,
  double value,
  int stock,

  @Pattern(regexp = "\\d{2}")
  String stateStorage
) {}
