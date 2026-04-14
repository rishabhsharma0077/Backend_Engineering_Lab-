package in.ashokit.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.user_service.entity.User;
import in.ashokit.user_service.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	 @Autowired
	    private UserRepository repo;

	    @Override
	    public User saveUser(User user) {
	        return repo.save(user);
	    }

	    @Override
	    public List<User> getAllUsers() {
	        return repo.findAll();
	    }

	    @Override
	    public User getUserById(Integer id) {
	        return repo.findById(id).orElse(null);
	    }

	    @Override
	    public User updateUser(User user) {
	        return repo.save(user);
	    }

	    @Override
	    public void deleteUser(Integer id) {
	        repo.deleteById(id);
	    }

}
