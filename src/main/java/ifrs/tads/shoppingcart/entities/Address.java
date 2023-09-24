package ifrs.tads.shoppingcart.entities;

import ifrs.tads.shoppingcart.dtos.AddressDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "addresses")
@Entity(name = "Address")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String zipCode;
  private String street;
  private String number;
  private String complement;
  private String neighborhood;
  private String city;
  private String state;
  private String add;
  
  public Address(AddressDTO addressData) {

    this.zipCode = addressData.zipCode();
    this.street = addressData.street();
    this.number = addressData.number();
    this.complement = addressData.complement();
    this.neighborhood = addressData.neighborhood();
    this.city = addressData.city();
    this.state = addressData.state();
    this.add = addressData.add();
    
  }

  public void updateInfo(AddressDTO addressData) {
    
    this.zipCode = addressData.zipCode() != null 
      ? addressData.zipCode() : this.zipCode;

    this.street = addressData.street() != null 
      ? addressData.street() : this.street;

    this.number = addressData.number() != null 
      ? addressData.number() : this.number;

    this.complement   = addressData.complement() != null 
      ? addressData.complement() : this.complement;

    this.neighborhood = addressData.neighborhood() != null 
      ? addressData.neighborhood() : this.neighborhood;

    this.city = addressData.city() != null 
      ? addressData.city() : this.city;

    this.state = addressData.state() != null 
      ? addressData.state() : this.state;

    this.add = addressData.add() != null 
      ? addressData.add() : this.add;;

  }
}
