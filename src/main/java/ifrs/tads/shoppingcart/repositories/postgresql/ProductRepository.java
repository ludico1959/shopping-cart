package ifrs.tads.shoppingcart.repositories.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrs.tads.shoppingcart.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {}
