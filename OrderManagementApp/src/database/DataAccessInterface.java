package database;

import java.util.ArrayList;

import javax.ejb.Local;

import model.Product;

@Local
public interface DataAccessInterface {
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
