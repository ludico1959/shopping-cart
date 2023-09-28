package ifrs.tads.shoppingcart.dtos;

import ifrs.tads.shoppingcart.entities.Product;

public record ProductProjectionDTO(
  String id,
  String name,
  float price,
  int stock,
  String stateStorage
) {
    public ProductProjectionDTO(Product product) {
    this(product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getStateStorage());
  }

}
