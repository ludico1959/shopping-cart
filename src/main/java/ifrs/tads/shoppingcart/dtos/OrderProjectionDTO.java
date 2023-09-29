package ifrs.tads.shoppingcart.dtos;

import java.time.LocalDateTime;

import ifrs.tads.shoppingcart.entities.User;

public record OrderProjectionDTO(
  String id,
  User user,
  LocalDateTime dateTime
) {}
