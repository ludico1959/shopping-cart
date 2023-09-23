package ifrs.tads.shoppingcart.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ViaCepDTO(
  @JsonProperty("cep")
  String zipCode,

  @JsonProperty("logradouro")
  String street,

  @JsonProperty("bairro")
  String neighborhood,

  @JsonProperty("localidade")
  String city,

  @JsonProperty("uf")
  String state,

  @JsonProperty("ddd")
  String add
) {}
