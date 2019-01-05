package jmv74211.DSS_P4.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jmv74211.DSS_P4.DAO.ShippingCartProductDao;
import jmv74211.DSS_P4.DAO.ProductDao;
import jmv74211.DSS_P4.DAO.ShippingCartDao;
import jmv74211.DSS_P4.models.ShippingCartProduct;
import jmv74211.DSS_P4.models.ShippingCartProductPK;

@Path("shippingCart/{id}/products")
public class ShippingCartProductResource {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public ArrayList<ShippingCartProduct> getAllShippingCartProduct(@PathParam("id") int id){
		
		System.out.println("called getAllShippingCartProduct()");
		
		ShippingCartProductDao  shippingCartProductDao = new ShippingCartProductDao();
		
		Query query = shippingCartProductDao.query("SELECT a FROM ShippingCartProduct a WHERE a.cartId="+ id +"");
		
		List<ShippingCartProduct> shippingCartProductList = new ArrayList<ShippingCartProduct>();
		shippingCartProductList = query.getResultList();

		return (ArrayList<ShippingCartProduct>) shippingCartProductList;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response addProduct(ShippingCartProduct shippingCartProduct){
		
		if(!shippingCartProduct.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			ShippingCartProductDao shippingCartProductDao = new ShippingCartProductDao();
			ShippingCartDao shippingCartDao = new ShippingCartDao();
			ProductDao productDao = new ProductDao();
			
			shippingCartProductDao.addProduct(shippingCartDao.getShippingCart(shippingCartProduct.getCartId()), 
					productDao.getProduct(shippingCartProduct.getProductId()),shippingCartProduct.getQuantity());			
			
			String json = "{ \"result\": \"It has been successfully added " + shippingCartProduct.getQuantity() + " products with id = " + 
					shippingCartProduct.getProductId() + " to the cart with id = " + shippingCartProduct.getCartId()+ "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@POST
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateShippingCartProduct(@PathParam("id") int id,ShippingCartProduct shippingCartProduct){
		
		
		if(!shippingCartProduct.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			
			ShippingCartProductDao shippingCartProductDao = new ShippingCartProductDao();
			
			ShippingCartProductPK pk = new ShippingCartProductPK(shippingCartProduct.getCartId(),shippingCartProduct.getProductId());
			
			ShippingCartProduct shippingCartProductObject = shippingCartProductDao.getCartProduct(pk);
			
			if(shippingCartProductObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"Wrong data\" }").build();
			}
			
			shippingCartProductObject.setQuantity(shippingCartProduct.getQuantity());
			
			shippingCartProductDao.save(shippingCartProductObject);
			
			String json = "{ \"result\": \"It has been successfully updated. Now the cart with id = " + shippingCartProduct.getCartId() + " has " +  
			shippingCartProduct.getQuantity() + "products with id = " + shippingCartProduct.getProductId() + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@DELETE
	@Path("/{productId}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteShippingCartProduct(@PathParam("id") int cartId, @PathParam("productId") int productId ){
		
	
		ShippingCartProductDao shippingCartProductDao = new ShippingCartProductDao();
		
		ShippingCartProductPK pk = new ShippingCartProductPK(cartId,productId);
		
		ShippingCartProduct shippingCartProductObject = shippingCartProductDao.getCartProduct(pk);
		
		if(shippingCartProductObject == null){
			return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"Wrong id params\"}").build();
		}
		
		shippingCartProductDao.delete(shippingCartProductObject);
		
		String json = "{ \"result\": \"It has been successfully deleted. Now the cart with id = " + shippingCartProductObject.getCartId() + 
				" does not have any product with id = " + shippingCartProductObject.getProductId() + "\"}";
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
					
	}
}
