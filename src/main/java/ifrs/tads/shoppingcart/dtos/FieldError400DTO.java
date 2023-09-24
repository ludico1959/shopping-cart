package ifrs.tads.shoppingcart.dtos;

import org.springframework.validation.FieldError;

public record FieldError400DTO(
  String field,
  String message
) {

  public FieldError400DTO(FieldError fieldError) {
    this(fieldError.getField(), fieldError.getDefaultMessage());
  }

}
