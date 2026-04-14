package in.example.demo.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.example.demo.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
