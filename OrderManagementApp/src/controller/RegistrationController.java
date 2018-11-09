package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.User;

@ManagedBean
@SessionScoped
public class RegistrationController {
	
	// Declare variables for LoginController
    private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	/* Getters and Setters for Username and Password
	 * These grab the value from the form and set the respective variable. */
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getEmail() {return email;}
	public String getPhoneNumber() {return phoneNumber;}
	
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setEmail(String email) {this.email = email;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	
	// Construct default User Object
//	User newUser = new User(username, password, firstName, lastName, email, phoneNumber);
	
	public void register(){
		//get the new user values from the register form
		FacesContext context = FacesContext.getCurrentInstance();
		User newUser = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		//put new user object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", newUser);
		
		try {
			context.getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Whoops, your username and password are incorrect.");
		    FacesContext.getCurrentInstance().addMessage("registrationForm:password", msg);
		}
	}
	

}
