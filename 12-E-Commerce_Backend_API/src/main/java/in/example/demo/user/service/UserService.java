package in.example.demo.user.service;

import java.util.List;

import in.example.demo.user.entity.User;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    User get(Long id);
    void delete(Long id);
    User getUserById(Long userId); 
}