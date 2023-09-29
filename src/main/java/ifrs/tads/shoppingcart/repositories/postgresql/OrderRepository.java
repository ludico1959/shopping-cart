package ifrs.tads.shoppingcart.repositories.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrs.tads.shoppingcart.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String> {}
