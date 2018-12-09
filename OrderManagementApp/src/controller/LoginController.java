package controller;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import business.UserBusinessInterface;
import model.User;

/**
* The LoginController is a session scoped, managed bean that controls user login. 
* Prior to FORM-Auth implementation, the LoginController utilized the UserBusinessInterface
* to manage user authentication for login.
*
* @author  Roman Parkhomenko
* @version 1.0
* @since   2018-12-08 
*/

@ManagedBean
@SessionScoped
public class LoginController {
	
	// Inject UserBusinessInterface
	@Inject
	private UserBusinessInterface userService;
	   
	// Login function called by Login Form command button.
	public String login(){
		
		//Get the creds from the login form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		//Call the array list from user service.
		final List<User> users = userService.getUserList();
		
		//Loop through arraylist to see if login creds match existing user.
		//If so, redirect to the homepage. 
		for (int i = 0; i < users.size(); i++) {
			User u = userService.getUser(i);
			System.out.println(u.getUsername() + " " + u.getEmail());
			if( u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", u);
				//go to main page if login data is correct
				return "app/home.xhtml";
			}
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Whoops, your username and password are incorrect.");
	    FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
		//refresh page if login data is incorrect
		return "login.xhtml";
	}
	 
	// Logout function called in home page.
    public void logout() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().invalidateSession();
        try {
			context.getExternalContext().redirect("../faces/login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
 // Logout function called in home page.
    public String onLogoff() {
    	// Invalidate the Session to clear the security token
    	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    		
    	// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
    	return "../faces/login.xhtml?faces-redirect=true";
    }
    
    // Get User Service
    public UserBusinessInterface getService() {
		return userService;
	}
	    
}