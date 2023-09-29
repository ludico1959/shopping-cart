package ifrs.tads.shoppingcart.entities;

import ifrs.tads.shoppingcart.dtos.ItemCreateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "itens")
@Entity(name = "Item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private int amount;
  
  @ManyToOne
  @JoinColumn(name = "prudct_id") 
  private Product product;

  @ManyToOne
  @JoinColumn(name = "order_id") 
  private Order order;

  public Item(ItemCreateDTO itemData) {
    
    this.amount = itemData.amount();
    this.product = itemData.product();
    this.order = itemData.order();

  }

}
