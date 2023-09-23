package ifrs.tads.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ifrs.tads.shoppingcart.dtos.AddressDTO;
import ifrs.tads.shoppingcart.dtos.ShortAddressDTO;
import ifrs.tads.shoppingcart.dtos.ViaCepDTO;
import ifrs.tads.shoppingcart.entities.Address;
import ifrs.tads.shoppingcart.repositories.AddressRepository;

@Service
public class AddressService {
  @Autowired
  private AddressRepository repository;

  public Address create(ShortAddressDTO addressData) {
    String url = String.format("https://viacep.com.br/ws/%s/json/", addressData.zipCode().replace("-", ""));

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<ViaCepDTO> viaCepData = restTemplate.getForEntity(url, ViaCepDTO.class);

    AddressDTO fullAddressData = new AddressDTO(
      addressData.number(), 
      addressData.complement(), 
      viaCepData.getBody().zipCode(), 
      viaCepData.getBody().street(),
      viaCepData.getBody().neighborhood(), 
      viaCepData.getBody().city(),
      viaCepData.getBody().state(),
      viaCepData.getBody().add()
     );


    Address address = repository.save(new Address(fullAddressData));

    return address;
  }
}
