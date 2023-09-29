package ifrs.tads.shoppingcart.repositories.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrs.tads.shoppingcart.entities.Item;

public interface ItemRepositiry extends JpaRepository<Item, String> {}
