package ifrs.tads.shoppingcart.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserCreateDTO(
  @NotBlank
  String name,

  @NotBlank
  @Email
  String email,

  @NotBlank
  @Pattern(regexp = "\\d{8,15}")
  String password,

  @NotNull
  @Valid
  ShortAddressDTO addressInfo
) {}
