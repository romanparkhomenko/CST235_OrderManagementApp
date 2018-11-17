package business;

import java.util.List;

import javax.ejb.Local;

import model.Product;

@Local
public interface ProductBusinessInterface {
	public void addProduct(Product product);
	public Product getProduct(int index);
	public List<Product> getProductList();
}