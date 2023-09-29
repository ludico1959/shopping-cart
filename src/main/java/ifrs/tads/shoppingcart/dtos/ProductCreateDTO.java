package ifrs.tads.shoppingcart.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProductCreateDTO(
  @NotBlank
  String name,

  float price,

  int stock,

  @NotBlank
  @Pattern(regexp = "^[A-Z]{2}$")
  String stateStorage 
) {}
