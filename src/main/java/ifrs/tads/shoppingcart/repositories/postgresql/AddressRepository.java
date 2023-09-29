package ifrs.tads.shoppingcart.repositories.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrs.tads.shoppingcart.entities.Address;

public interface AddressRepository extends JpaRepository<Address, String> {}
