package ifrs.tads.shoppingcart.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ifrs.tads.shoppingcart.dtos.AddressDTO;
import ifrs.tads.shoppingcart.dtos.ShortAddressDTO;
import ifrs.tads.shoppingcart.dtos.ViaCepDTO;

public class ViaCep {
  public static AddressDTO generateAddress(ShortAddressDTO addressData) {
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

    return fullAddressData;
  }
}
