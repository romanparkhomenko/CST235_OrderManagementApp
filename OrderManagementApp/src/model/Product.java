package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Product {
	private String productName;
	private int quantity;
	private int id;
	private double cost;
	private String description;
	
	//Constructor
	public Product(String productName, int quantity, int id, double cost, String description) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.id = id;
		this.cost = cost;
		this.description = description;
	}
	
	//Default Generic Constructor
	public Product(){
//		productName = getProductName();
//		quantity = getQuantity();
//		id = getId();
//		cost = getCost();
//		description = getDescription();
	}
	
    // Getters for user data
	public String getProductName() {return productName;}
	public int getQuantity() {return quantity;}
	public int getId() {return id;}
	public double getCost() {return cost;}
	public String getDescription() {return description;}
	
	// Setters for user data
	public void setProductName(String productName) {this.productName = productName;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	public void setId(int id) {this.id = id;}
	public void setCost(double cost) {this.cost = cost;}
	public void setDescription(String description) {this.description = description;}
		
}
