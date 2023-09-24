package ifrs.tads.shoppingcart.entities;

import ifrs.tads.shoppingcart.dtos.UserCreateDTO;
import ifrs.tads.shoppingcart.dtos.UserUpdateDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;
  private String email;
  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private Address address;

  public User(UserCreateDTO userData, Address address) {

    this.name = userData.name();
    this.email = userData.email();
    this.password = userData.password();
    this.address = address;
    
  }

  public void updateInfo(UserUpdateDTO userData, Address address) {
    this.name = userData.name() != null 
      ? userData.name() : this.name;

    this.email = userData.email() != null 
      ? userData.email() : this.email;

    this.password = userData.password() != null 
      ? userData.password() : this.password;

    this.address = address != null 
      ? address : this.address;
  }
}
