package model;

public class Product {
	private String productName = "";
	private int quantity = 0;
	private int id = 0001;
	private double cost = 0.00;
	private String description = "Product";
	
	public Product(String name, int q, int id, double c, String descript) {
		productName = name;
		quantity = q;
		this.id = id;
		cost = c;
		description = descript;
	}
	
	public Product(){
		productName = getProductName();
		quantity = getQuantity();
		id = getId();
		cost = getCost();
		description = getDescription();
	}
	
	    // Getters for user data
		public String getProductName() {return productName;}
		public int getQuantity() {return quantity;}
		public int getId() {return id;}
		public double getCost() {return cost;}
		public String getDescription() {return description;}
		
		
		// Setters for user data
		public void setProductName(String product) {productName = product;}
		public void setQuantity(int q) {quantity = q;}
		public void setId(int id) {this.id = id;}
		public void setCost(double c) {cost = c;}
		public void setDescription(String descript) {description = descript;}
		
}
