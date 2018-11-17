package business;

import java.util.List;

import javax.ejb.Local;

import model.User;

@Local
public interface UserBusinessInterface {
	public void addUser(User user);
	public User getUser(int index);
	public List<User> getUserList();
}