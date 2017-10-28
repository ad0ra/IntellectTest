package springboot.assignment.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public UserResponse addUser(User user){
		return userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public UserResponse deactivateUser(@PathVariable String id){
		return userService.deleteUser(id);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public UserResponse updateUser(@PathVariable String id, User user){
		return userService.updateUser(id, user);
	}
}
