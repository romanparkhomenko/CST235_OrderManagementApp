package business;

import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import database.DataAccessInterface;
import model.Product;

@Stateless
@Local(ProductBusinessInterface.class)
public class ProductBusinessService implements ProductBusinessInterface {
	
	@Inject
	DataAccessInterface db;

	@Override
	public int addProduct(Product product) {
		return db.addProduct(product);
	}
	
	@Override
	public ArrayList<Product> readAll() {
		return db.readAll();
	}
	
	@Override
	public Product readOne(int id){
		return db.readOne(id);
	}
	
	@Override
	public int updateProduct(int id, Product product) {
		return db.updateProduct(id, product);
	}
	
	@Override
	public int deleteProduct(int id) {
		return db.deleteProduct(id);
	}
	
}
