package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import business.UserBusinessInterface;
import model.User;

/**
* The RegistrationController is a view scoped, managed bean that controls new user registration. 
* Prior to FORM-Auth implementation, the LoginController utilized the UserBusinessInterface
* to manage user authentication for login.
*
* @author  Roman Parkhomenko
* @version 1.0
* @since   2018-12-08 
* @deprecated Since admins are logged in through j_username and FROM-Auth, the registration hashmap is not recommended. 
*/

@ManagedBean
@ViewScoped
public class RegistrationController {
	
	// Inject UserBusinessInterface
	@Inject
	private UserBusinessInterface userService;
	
	public void register(){
		
		//Get the new user values from the register form and create user
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// Add new user to the Users ArrayList
		userService.addUser(user);
		
		try {
			context.getExternalContext().redirect("../faces/login.xhtml");
		} catch (IOException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Whoops, your username and password are incorrect.");
		    FacesContext.getCurrentInstance().addMessage("registrationForm:password", msg);
		}
	}
	
	 // Get User Service
    public UserBusinessInterface getService() {
		return userService;
	}

}
