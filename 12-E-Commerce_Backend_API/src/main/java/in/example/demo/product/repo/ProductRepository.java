package in.example.demo.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.example.demo.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
