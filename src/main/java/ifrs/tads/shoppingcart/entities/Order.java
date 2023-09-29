package ifrs.tads.shoppingcart.entities;

import java.time.LocalDateTime;
import java.util.List;

import ifrs.tads.shoppingcart.dtos.OrderCreateDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity(name = "Order")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private int amount;
  private LocalDateTime dateTime;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id") 
  private User user;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<Item> itens;

  public Order(OrderCreateDTO orderData) {
    
    this.user = orderData.user();
    this.dateTime = LocalDateTime.now();

  }

  public void AddItem(Item item) {
    this.itens.add(item);
  }
  
}
