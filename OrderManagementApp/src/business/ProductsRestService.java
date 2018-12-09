package business;

/**
* The ProductRestService is a JAX-RS implementation to build
* a RESTful API. The service is request scoped and both produces
* and consumes xml and json input. The Path for the REST API
* is /rest/products.
*
* @author  Roman Parkhomenko
* @version 1.0
* @since   2018-12-08 
*/

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Product;

@RequestScoped
@Path("/products")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ProductsRestService {
	
	@Inject
	ProductBusinessInterface service;
	
	// GET Request to Get All Products
	@GET
	@Path("/getAllJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllThingsAsJson(){
		return service.readAll();
	}
	
	// POST Request to Add New Product
	@POST
	@Path("/addProduct")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public void addProduct(@NotNull @FormParam("productName") String productName,
			@NotNull @FormParam("quantity") int quantity,
			@NotNull @FormParam("cost") float cost,
			@NotNull @FormParam("description") String description) {
		Product newProduct = new Product(100, productName, quantity, cost, description);
		service.addProduct(newProduct);
	}
}
