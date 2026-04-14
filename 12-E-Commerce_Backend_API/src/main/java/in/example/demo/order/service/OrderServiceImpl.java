package in.example.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.example.demo.order.entity.Order;
import in.example.demo.order.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order get(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
