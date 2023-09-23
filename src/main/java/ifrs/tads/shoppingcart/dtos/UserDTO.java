package ifrs.tads.shoppingcart.dtos;

public record UserDTO(
  String name,

  String email,

  String password,

  ShortAddressDTO addressInfo
) {}
