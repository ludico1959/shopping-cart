package ifrs.tads.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrs.tads.shoppingcart.entities.User;

public interface UserRepository extends JpaRepository<User, String>{}
