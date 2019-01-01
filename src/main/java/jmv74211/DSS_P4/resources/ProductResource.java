package jmv74211.DSS_P4.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jmv74211.DSS_P4.DAO.ProductDao;
import jmv74211.DSS_P4.models.Product;

@Path("/product")
public class ProductResource {
	
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createProduct(Product product){
		
		if(!product.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			ProductDao productDao = new ProductDao();
			
			productDao.save(product);
			
			String json = "{ result: Product successfully added with id = " + product.getProductId() + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteProduct(@PathParam("id") int id){
		
		
		ProductDao productDao = new ProductDao();
		
		Product productObject = productDao.getProduct(id);
		
		if(productObject == null){
			return Response.status(Response.Status.NO_CONTENT).entity("{result : ProductId does not exist}").build();
		}
		
		productDao.delete(productObject);
		
		String json = "{ result: Product successfully deleted with id = " + id + "}";
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();	
	}
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateProduct(@PathParam("id") int id,Product product){
		
		
		if(!product.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			ProductDao productDao = new ProductDao();
			
			Product productObject = productDao.getProduct(id);
			
			if(productObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{result : productId does not exist}").build();
			}
			
			productObject.setDepartment(product.getDepartment());
			productObject.setDescription(product.getDescription());
			productObject.setImageURL(product.getImageURL());
			productObject.setName(product.getName());
			productObject.setPrice(product.getPrice());
			productObject.setOutstanding(product.isOutstanding());
				
			productDao.save(productObject);
			
			String json = "{ result: Product successfully updated with id = " + productObject.getProductId() + "}";
						
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
}
