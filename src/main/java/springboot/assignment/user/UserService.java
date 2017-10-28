package springboot.assignment.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private List<User> users = new ArrayList<>();
	private int userId = 1;
	private UserResponse response;
	private ValidationError validationError;

	public List<User> getUser(){
		return users;
	}
	
	public UserResponse addUser(User user){
		User existingUser = users.stream().filter(z -> z.getEmail().equals(user.getEmail())).filter(u -> u.isActive()).findAny().get();
	
		if(existingUser == null){
			user.setId(""+userId);
			userId++;
			user.setActive(true);
			users.add(user);
			response.setResMsg("User Created");
			response.setUserId(user.getId());
			return response;
		}else{

			response.setResMsg("User already exist with provided email id");
			validationError.setCode("406");
			validationError.setField(user.getEmail());
			validationError.setMessage("Not Acceptable");
			response.setValErrors(validationError);
		return response;
		}
		}
	
	public UserResponse updateUser(String id, User user){
		DateFormat dateFormat = new SimpleDateFormat("DD-MON-YYYY");
		try {
			if(!dateFormat.parse(user.getBirthDate().toString()).after(Calendar.getInstance().getTime()) ){
				User existingUser = users.stream().filter(z -> z.getId().equals(id)).findFirst().get();
				
				existingUser.setBirthDate(user.getBirthDate());
				existingUser.setPinCode(user.getPinCode());
				response.setResMsg("User Updated");
				response.setUserId(id);
			}else{
				response.setResMsg("User id doesnot exists");
				response.setUserId(id);
				validationError.setCode("204");
				validationError.setField(id);
				validationError.setMessage("Not Found");
			}
		} catch (ParseException e) {
			response.setResMsg("Error in provide birthdate formate");
			response.setUserId(id);
			validationError.setCode("406");
			validationError.setField(user.getBirthDate().toString());
			validationError.setMessage("Not Acceptable");
			response.setValErrors(validationError);
			
		}
		return response;
	}
	
	public UserResponse deleteUser(String id){
		if(users.stream().filter(z -> z.getId().equals(id)).findFirst().get()!=null){
			users.stream().filter(z -> z.getId().equals(id)).findFirst().get().setActive(false);
			response.setResMsg("User Deleted");
			response.setUserId(id);
		}else{
			response.setResMsg("User id doesnot exists");
			response.setUserId(id);
			validationError.setCode("204");
			validationError.setField(id);
			validationError.setMessage("Not Found");
		}
		return response;
	}
}
