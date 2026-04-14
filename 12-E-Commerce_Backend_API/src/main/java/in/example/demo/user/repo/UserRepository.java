package in.example.demo.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.example.demo.user.entity.User;

public interface UserRepository extends  JpaRepository<User, Long> {

}
