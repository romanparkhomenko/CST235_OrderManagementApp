package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import business.ProductBusinessInterface;
import model.Product;


@ManagedBean
@SessionScoped
public class ProductController {
	
	// Inject ProductBusinessInterface
	@Inject
	private ProductBusinessInterface productService;
	
	// create function called by create Form command button.
	public void create() {
		
		Product newProduct = new Product();
		//Get the product details from the product form
		FacesContext context = FacesContext.getCurrentInstance();
		Product product = context.getApplication().evaluateExpressionGet(context, "#{product}", Product.class);
		
		newProduct.setProductName(product.getProductName());
		newProduct.setQuantity(product.getQuantity());
		newProduct.setCost(product.getCost());
		newProduct.setDescription(product.getDescription());
		// Console log product name.
		System.out.println(product.getProductName() + " has been created.");
		
		//Add product to product list.
		productService.addProduct(newProduct);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", product);
		
	}
	
	public void update() {
			
			Product updatedProduct = new Product();
			//Get the product details from the product form
			FacesContext context = FacesContext.getCurrentInstance();
			Product product = context.getApplication().evaluateExpressionGet(context, "#{product}", Product.class);
			
			updatedProduct.setProductName(product.getProductName());
			updatedProduct.setQuantity(product.getQuantity());
			updatedProduct.setCost(product.getCost());
			updatedProduct.setDescription(product.getDescription());
			
			//Update product in product list.
			productService.updateProduct(product.getID(), updatedProduct);
			// Console log product name.
			System.out.println(product.getProductName() + " has been updated.");
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", product);
			
	}

	public void delete() {
		
		//Get the product details from the product form
		FacesContext context = FacesContext.getCurrentInstance();
		Product product = context.getApplication().evaluateExpressionGet(context, "#{product}", Product.class);
		
		//Delete product from list and DB.
		productService.deleteProduct(product.getID());
		
		// Console log product name.
		System.out.println(product.getProductName() + " has been deleted.");
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", product);
		
	}
	
	// Function to generate product creation page
	public String createPage() {
		return "ProductCreation.xhtml";
	}
	
	// Get Product Service
    public ProductBusinessInterface getService() {
		return productService;
	}
	
}
