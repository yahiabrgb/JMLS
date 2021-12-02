package JMlessous.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import JMlessous.entities.*;
import JMlessous.repositories.*;


@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository UserRepository;
	
	@Override
	public List<User> RetrieveAllUsers(){
		List<User> user = (List<User>) UserRepository.findAll();
		return user;
	}
	
	@Override
	public User AddUser(User u) {
		User user = null;
		user = UserRepository.save(u);
		return user;
	}
	
	@Override
	public void DeleteUser(Long id) {
		UserRepository.deleteById(id);
	}
	
	@Override
	public User UpdateUser(User u) {
		User UserUpdated = UserRepository.save(u);
		return UserUpdated;
	}	
	
	@Override
	public User RetrieveUser(String id){
		User u = UserRepository.findById(Long.parseLong(id)).get();
		return u;
	}

	@Override
	public User RetrieveUserinfo(String username) {
		
		return UserRepository.RetrieveUserInfo(username);
	}
	
	
}
