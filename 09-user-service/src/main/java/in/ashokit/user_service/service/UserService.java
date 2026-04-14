package in.ashokit.user_service.service;

import java.util.List;

import in.ashokit.user_service.entity.User;

public interface UserService {
	 User saveUser(User user);
	    List<User> getAllUsers();
	    User getUserById(Integer id);
	    User updateUser(User user);
	    void deleteUser(Integer id);

}
