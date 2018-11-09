package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.User;

@ManagedBean
@SessionScoped
public class LoginController {
	
	// Declare variables for LoginController
    private String username;
	private String password;
	
	// Construct default User Object
	User defaultUser = new User();
	
	/* Getters and Setters for Username and Password
	 * These grab the value from the form and set the respective variable. */
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	   
	// Login function called by Login Form command button.
	public void login() {
		//checking console log for username
		System.out.println(defaultUser.getUsername());
		
        FacesContext context = FacesContext.getCurrentInstance();
        // Conditional check to see if UN and password match form input, if not, print message.
       if(this.username.equals(defaultUser.getUsername()) && this.password.equals(defaultUser.getPassword())){
            context.getExternalContext().getSessionMap().put("user", defaultUser);
            try {
				context.getExternalContext().redirect("app/home.xhtml");
			} catch (IOException e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Whoops, your username and password are incorrect.");
			    FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
			}
        }
        else {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Whoops, your username and password are incorrect.");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        }
     }
	 
	// Logout function called in home page.
    public void logout() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().invalidateSession();
        try {
			context.getExternalContext().redirect("../login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	    
}
