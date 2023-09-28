package ifrs.tads.shoppingcart.entities;

import ifrs.tads.shoppingcart.dtos.ProductCreateDTO;
import ifrs.tads.shoppingcart.dtos.ProductUpdateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity(name = "Product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;
  private float price;
  private int stock;
  private String stateStorage;

  public Product(ProductCreateDTO productData) {
    this.name = productData.name();
    this.price = productData.price();
    this.stock = productData.stock();
    this.stateStorage = productData.stateStorage();
  }

  public void updateInfo(ProductUpdateDTO productData) {
    this.name = productData.name() != null 
      ? productData.name() : this.name;

    this.price = productData.price() != 0 
      ? productData.price() : this.price;

    this.stateStorage = productData.stateStorage() != null 
      ? productData.stateStorage() : this.stateStorage;
  }
}
