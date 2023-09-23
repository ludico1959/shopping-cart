package ifrs.tads.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifrs.tads.shoppingcart.dtos.AddressDTO;
import ifrs.tads.shoppingcart.dtos.ShortAddressDTO;
import ifrs.tads.shoppingcart.entities.Address;
import ifrs.tads.shoppingcart.repositories.AddressRepository;
import ifrs.tads.shoppingcart.utils.ViaCep;

@Service
public class AddressService {
  @Autowired
  private AddressRepository repository;

  public Address create(ShortAddressDTO addressData) {
    AddressDTO fullAddressData = ViaCep.generateAddress(addressData);

    Address address = repository.save(new Address(fullAddressData));

    return address;
  }

  public Address update(ShortAddressDTO addressData) {
    AddressDTO fullAddressData = ViaCep.generateAddress(addressData);

    Address address = this.repository.getReferenceById(addressData.id());

    address.updateInfo(fullAddressData);

    return address;
  }
}
