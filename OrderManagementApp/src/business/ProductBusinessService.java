package business;

import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import database.DataAccessInterface;
import model.Product;

/**
* The ProductBusinessService is a Stateless, Local bean which encapsulates
* product management by implementing the DataAccessInterface. The methods used
* in this service call the CRUD methods of the DataAccessInterface.
*
* @author  Roman Parkhomenko
* @version 1.0
* @since   2018-12-08 
*/

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
