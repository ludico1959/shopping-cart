package ifrs.tads.shoppingcart.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ifrs.tads.shoppingcart.dtos.ProductCreateDTO;
import ifrs.tads.shoppingcart.dtos.ProductProjectionDTO;
import ifrs.tads.shoppingcart.dtos.ProductUpdateDTO;
import ifrs.tads.shoppingcart.entities.Product;
import ifrs.tads.shoppingcart.services.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
  
  @Autowired
  private ProductService service;

  @PostMapping
  @Transactional
  public ResponseEntity<ProductProjectionDTO> create(
    @RequestBody @Valid ProductCreateDTO productData, UriComponentsBuilder uriComponentsBuilder) {

      Product product = this.service.create(productData);

      URI uri = uriComponentsBuilder
                .path("/products/{id}")
                .buildAndExpand(product.getId())
                .toUri();

      return ResponseEntity.created(uri).body(new ProductProjectionDTO(product));

    }

    @GetMapping
    public ResponseEntity<Page<ProductProjectionDTO>> list() {

      Page<ProductProjectionDTO> page = this.service.list();

      return ResponseEntity.ok(page);

    } 

    @GetMapping("/{id}")
    public ResponseEntity<ProductProjectionDTO> findById(@PathVariable String id) {

      Product product = this.service.findByID(id);

      return ResponseEntity.ok(new ProductProjectionDTO(product));

    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProductProjectionDTO> update(@RequestBody ProductUpdateDTO productData) {
      Product product = this.service.update(productData);

      return ResponseEntity.ok(new ProductProjectionDTO(product));
    } 

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable String id) {
      this.service.delete(id);

      return ResponseEntity.noContent().build();
    }

}
