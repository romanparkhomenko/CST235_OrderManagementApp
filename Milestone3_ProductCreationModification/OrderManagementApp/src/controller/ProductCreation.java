package controller;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;

import model.Product;

@ManagedBean
@ApplicationScoped
public class ProductCreation {
	
	// Declare variables for ProductController
    private String productName;
	private String description;
	private int id;
	private double cost;
	private int quantity;
	
	// Construct default User Object
	
	
	Product defaultProduct = new Product("AlienWare 17", 5, 0001, 1500.00, "The best gaming laptop the dell has to offer.");

			
	
	/* Getters and Setters
	 * These grab the value from the form and set the respective variable. */
	public String getProductName() {return productName;}
	public String getDescription() {return description;}
	public int getId() {return id;}
	public double getCost() {return cost;}
	public int getQuantity() {return quantity;}
	public void setProductName(String productName) {this.productName = productName;}
	public void setDescription(String description) {this.description = description;}
	public void setId(int id) {this.id = id;}
	public void setCost(double cost) {this.cost = cost;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	   
	// create function called by create Form command button.
	public void create() {

		
		System.out.println(getProductName() + "has been created.");
		
        FacesContext context = FacesContext.getCurrentInstance();
        
      
     }
	 public void createPage() {
		 System.out.println("Load Product Create Page");
	 }
	
	    
}
