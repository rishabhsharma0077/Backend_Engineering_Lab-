package in.example.demo.order.service;

import java.util.List;

import in.example.demo.order.entity.Order;

public interface OrderService {
    List<Order> getAllOrders();
    void save(Order order);
    Order get(Long id);
    void delete(Long id);
}
