package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import model.Product;

@Stateless
@Local(ProductBusinessInterface.class)
public class ProductBusinessService implements ProductBusinessInterface {
	
	// ArrayList users to hold user object
	public List<Product> products = new ArrayList<Product>();
	
	// Constructor adds one generic user.
	public ProductBusinessService(){
		products.add(new Product("AlienWare 17", 5, 0001, 1500.00, "The best gaming laptop the dell has to offer."));
	}
	// Add user to ArrayList
	public void addProduct(Product product){
		products.add(product);
	}
	// Get user from ArrayList
	public Product getProduct(int index){
		return products.get(index);
	}
	// Get entire ArrayList
	public List<Product> getProductList(){
		return this.products;
	}
}
