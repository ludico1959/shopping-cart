package ifrs.tads.shoppingcart.errors;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ifrs.tads.shoppingcart.dtos.FieldError400DTO;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandling {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<String> HandleError404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<FieldError400DTO>> HandleError400(MethodArgumentNotValidException exception) {
    List<FieldError> fieldErrors = exception.getFieldErrors();

    return ResponseEntity.badRequest().body(fieldErrors.stream().map(FieldError400DTO::new).toList());
  }
  
}
