package in.ashokit.restaurent.service;

import java.util.List;

import in.ashokit.restaurent.entity.Restaurent;

public interface RestaurantService {
	List<Restaurent> getAllRestaurants();

	Restaurent addRestaurant(Restaurent restaurant);
}