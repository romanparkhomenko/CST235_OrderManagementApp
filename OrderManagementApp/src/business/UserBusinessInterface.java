package business;

import java.util.List;

import javax.ejb.Local;

import model.User;

/**
* The UserBusinessInterface is a Local interface that allows
* implementation of the UserBusinessService
*
* @author  Roman Parkhomenko
* @version 1.0
* @since   2018-12-08 
*/

@Local
public interface UserBusinessInterface {
	public void addUser(User user);
	public User getUser(int index);
	public List<User> getUserList();
}