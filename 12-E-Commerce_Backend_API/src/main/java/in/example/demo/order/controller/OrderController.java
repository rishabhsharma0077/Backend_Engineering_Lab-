package in.example.demo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.example.demo.order.entity.Order;
import in.example.demo.order.service.OrderService;
import in.example.demo.product.entity.Product;
import in.example.demo.product.service.ProductService;
import in.example.demo.user.entity.User;
import in.example.demo.user.service.UserService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("/orders/place")
    public String placeOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("products", productService.getAll());
        return "place_order";
    }

    @PostMapping("/orders/save")
    public String saveOrder(@ModelAttribute("order") Order order,
                            @RequestParam("userId") Long userId,
                            @RequestParam("productId") Long productId) {

        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);

        order.setUser(user);
        order.setProduct(product);

        orderService.save(order);
        return "redirect:/orders";
    }

}