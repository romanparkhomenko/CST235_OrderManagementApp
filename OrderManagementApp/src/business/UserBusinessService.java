package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import model.User;

/**
* The ProductBusinessService is a Stateless, Local bean which encapsulates
* user management by implementing the UserBusinessInterface. This service
* allows the management of a hashmap of users prior to FORM-Authentication.
*
* @author  Roman Parkhomenko
* @version 1.0
* @since   2018-12-08 
*/

@Stateless
@Local(UserBusinessInterface.class)
public class UserBusinessService implements UserBusinessInterface {
	
	// ArrayList users to hold user object
	public List<User> users = new ArrayList<User>();
	
	// Constructor adds one generic user.
	public UserBusinessService(){
		users.add(new User("admin","admin", "Roman", "Zachary", "roman@test.com", "1234567890"));
	}
	// Add user to ArrayList
	public void addUser(User user){
		users.add(user);
	}
	// Get user from ArrayList
	public User getUser(int index){
		return users.get(index);
	}
	// Get entire ArrayList
	public List<User> getUserList(){
		return this.users;
	}
}
