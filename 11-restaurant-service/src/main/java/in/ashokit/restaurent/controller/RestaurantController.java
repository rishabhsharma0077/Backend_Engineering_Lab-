package in.ashokit.restaurent.controller;


import org.springframework.web.bind.annotation.*;

import in.ashokit.restaurent.entity.Restaurent;
import in.ashokit.restaurent.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Restaurent> getAll() {
        return service.getAllRestaurants();
    }

    @PostMapping("/add")
    public Restaurent add(@RequestBody Restaurent restaurant) {
        return service.addRestaurant(restaurant);
    }
}