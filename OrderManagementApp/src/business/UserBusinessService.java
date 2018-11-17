package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import model.User;

@Stateless
@Local(UserBusinessInterface.class)
public class UserBusinessService implements UserBusinessInterface {
	
	// ArrayList users to hold user object
	public List<User> users = new ArrayList<User>();
	
	// Constructor adds one generic user.
	public UserBusinessService(){
		users.add(new User("GCURedTeam","password", "Roman", "Zachary", "roman@test.com", "1234567890"));
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
