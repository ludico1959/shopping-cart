package ifrs.tads.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ifrs.tads.shoppingcart.dtos.ProductCreateDTO;
import ifrs.tads.shoppingcart.dtos.ProductProjectionDTO;
import ifrs.tads.shoppingcart.dtos.ProductUpdateDTO;
import ifrs.tads.shoppingcart.entities.Product;
import ifrs.tads.shoppingcart.repositories.postgresql.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Product create(ProductCreateDTO productData) {

    Product product = this.repository.save(new Product(productData));

    return product;

  }

  public Page<ProductProjectionDTO> list() {

    Pageable pageable = PageRequest.of(0, 5, Sort.by("name"));

    return this.repository
      .findAll(pageable)
      .map(ProductProjectionDTO::new);

  }

  public Product findByID(String productId) {

    return this.repository.getReferenceById(productId);

  }

  public Product update(ProductUpdateDTO productData) {

    Product product = this.repository.getReferenceById(productData.id());

    product.updateInfo(productData);

    return product;
    
  }

  public void delete(String productId) {

    this.repository.deleteById(productId);

  }

}
