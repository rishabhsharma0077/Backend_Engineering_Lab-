package in.example.demo.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import in.example.demo.product.entity.Product;
import in.example.demo.user.entity.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders") // "order" is a reserved SQL keyword
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private int quantity;

    private Date orderDate = new Date();
}