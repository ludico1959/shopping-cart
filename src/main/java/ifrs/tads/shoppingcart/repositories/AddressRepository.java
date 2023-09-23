package ifrs.tads.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrs.tads.shoppingcart.entities.Address;

public interface AddressRepository extends JpaRepository<Address, String> {}
