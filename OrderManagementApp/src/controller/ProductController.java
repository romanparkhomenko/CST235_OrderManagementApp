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
	
	Product newProduct = new Product();
	// create function called by create Form command button.
	public void create() {
		
		//Get the product details from the product form
		FacesContext context = FacesContext.getCurrentInstance();
		Product product = context.getApplication().evaluateExpressionGet(context, "#{product}", Product.class);
		
		newProduct.setProductName(product.getProductName());
		newProduct.setQuantity(product.getQuantity());
		newProduct.setId(product.getId());
		newProduct.setCost(product.getCost());
		newProduct.setDescription(product.getDescription());
		// Console log product name.
		System.out.println(product.getProductName() + " has been created.");
		
		//Add product to product list.
		productService.addProduct(newProduct);
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
