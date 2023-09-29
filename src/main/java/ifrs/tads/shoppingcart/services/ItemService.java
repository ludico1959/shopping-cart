package ifrs.tads.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifrs.tads.shoppingcart.dtos.ItemCreateDTO;
import ifrs.tads.shoppingcart.entities.Item;
import ifrs.tads.shoppingcart.repositories.postgresql.ItemRepositiry;

@Service
public class ItemService {
  
  @Autowired
  private ItemRepositiry repository;

  public Item create(ItemCreateDTO itemData) {

    Item item = this.repository.save(new Item(itemData));

    return item;

  }

}
