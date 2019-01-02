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


import jmv74211.DSS_P4.DAO.ShippingCartDao;
import jmv74211.DSS_P4.models.ShippingCart;

@Path("shippingCart")
public class ShippingCartResource {

	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createShippingCart(ShippingCart shippingCart){
		
		if(!shippingCart.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{ \"result\" : \"Wrong data parameters\" }").build();
		}
		else{
			
			ShippingCartDao shippingCartDao = new ShippingCartDao();
			
			shippingCartDao.save(shippingCart);
			
			String json = "{ \"result\" : \"ShippingCart successfully added with id = " + shippingCart.getCartId() + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}		
	}
	
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateShippingCart(@PathParam("id") int id,ShippingCart shippingCart){
		
		
		if(!shippingCart.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{ \"result\" : \"Wrong data parameters\" }").build();
		}
		else{
			
			ShippingCartDao shippingCartDao = new ShippingCartDao();
			
			ShippingCart shippingCartObject = shippingCartDao.getShippingCart(id);
			
			if(shippingCartObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{ \"result\" : \"shippingCartId does not exist\" }").build();
			}
			
			shippingCartObject.setCustomer(shippingCart.getCustomer());
			shippingCartObject.setPrice(shippingCart.getPrice());
			
			shippingCartDao.save(shippingCartObject);
			
			String json = "{ \"result\": \"ShippingCart successfully updated with id = " + shippingCartObject.getCartId() + "\"}";
						
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteShippingCart(@PathParam("id") int id){
		
		
		ShippingCartDao shippingCartDao = new ShippingCartDao();
		
		ShippingCart shippingCartObject = shippingCartDao.getShippingCart(id);
		
		if(shippingCartObject == null){
			return Response.status(Response.Status.NO_CONTENT).entity("{ \"result\" : \"shippingCartId does not exist\" }").build();
		}
		
		shippingCartDao.delete(shippingCartObject);
		
		String json = "{ \"result\" : \"ShippingCart successfully deleted with id = " + id + "\"}";
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();	
	}
	
	
	
	
}
