package ifrs.tads.shoppingcart.dtos;

public record ShortAddressDTO(
  String zipCode,

  String number,

  String complement
) {}