package in.ashokit.user_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
