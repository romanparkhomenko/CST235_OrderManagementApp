package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@SessionScoped
@XmlRootElement(name="Product") 
public class Product {
//	@NotNull(message="Please enter an ID Number.")
//	@Size(min=1, max=3)
	private int id;
	
//	@NotNull(message="Please enter a Product Name")
//	@Size(min=1, max=40)
	private String productName;
	
//	@NotNull(message="Please enter a Product Quantity")
//	@Size(min=1, max=1000)
	private int quantity;
	
//	@NotNull(message="Please enter the Product Cost")
//	@Size(min=1, max=1000)
	private float cost;
	
//	@NotNull(message="Please enter the Product Description")
//	@Size(min=1, max=1000)
	private String description;
	
	//Constructor
	public Product(int id, String productName, int quantity,  float cost, String description) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
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
	public int getID() {return id;}
	public String getProductName() {return productName;}
	public int getQuantity() {return quantity;}
	public float getCost() {return cost;}
	public String getDescription() {return description;}
	
	// Setters for user data
	public void setID(int id) {this.id = id;}
	public void setProductName(String productName) {this.productName = productName;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	public void setCost(float cost) {this.cost = cost;}
	public void setDescription(String description) {this.description = description;}
		
}
