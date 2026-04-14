package in.ashokit.restaurent.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.restaurent.entity.Restaurent;

public interface RestaurantRepository extends JpaRepository<Restaurent, Integer> {

}
