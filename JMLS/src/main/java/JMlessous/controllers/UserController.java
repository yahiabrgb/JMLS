package JMlessous.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JMlessous.services.*;
import JMlessous.entities.*;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService UserService;
  	
	@GetMapping("/userinfo/{username}")
	@ResponseBody
	public User getUserinfo(@PathVariable("username") String username) {
	 return UserService.RetrieveUserinfo(username);
	}
	
	
	@PutMapping("/updateuser")
	@ResponseBody
	public User updateUser(@RequestBody User user){
	return UserService.UpdateUser(user);
	}
	
	@GetMapping("/getusers")
	@ResponseBody
	public List<User> getUsers() {
	 return UserService.RetrieveAllUsers();
	}
		
}