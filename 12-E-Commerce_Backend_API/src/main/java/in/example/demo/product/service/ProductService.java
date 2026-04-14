package in.example.demo.product.service;

import java.util.List;

import in.example.demo.product.entity.Product;

public interface ProductService {
    List<Product> getAll();
    Product get(Long id);
    void save(Product product);
    void delete(Long id);
    Product getProductById(Long productId);
}