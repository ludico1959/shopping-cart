package ifrs.tads.shoppingcart.dtos;

public record AddressDTO(
  String number,

  String complement,

  String zipCode,

  String street,

  String neighborhood,

  String city,

  String state,

  String add
) {}