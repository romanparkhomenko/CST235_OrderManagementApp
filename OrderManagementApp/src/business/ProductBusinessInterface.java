package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.Product;

/**
* The ProductBusinessInterface is a Stateless, Local, interface used to 
* implement the ProductBusinessService
*
* @author  Roman Parkhomenko
* @version 1.0
* @since   2018-12-08 
*/
@Stateless
@Local
public interface ProductBusinessInterface {
	// All CRUD Operations
	
	// CREATE
	public int addProduct(Product product);
	// READ
	public ArrayList<Product> readAll();
	public Product readOne(int id);
	// UPDATE
	public int updateProduct(int id, Product product);
	// DELETE
	public int deleteProduct(int id);
}