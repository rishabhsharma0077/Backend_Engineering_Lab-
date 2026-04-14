package in.ashokit.restaurent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.restaurent.entity.Restaurent;
import in.ashokit.restaurent.repo.RestaurantRepository;

@Service

public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository repo;

	public RestaurantServiceImpl(RestaurantRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Restaurent> getAllRestaurants() {
		

		return repo.findAll();
	}

	@Override
	public Restaurent addRestaurant(Restaurent restaurant) {
		System.out.println("Restaurant received: " + restaurant); // Debug print

		return repo.save(restaurant);
	}

}
