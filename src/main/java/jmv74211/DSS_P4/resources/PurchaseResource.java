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

import jmv74211.DSS_P4.DAO.PurchaseDao;
import jmv74211.DSS_P4.models.Purchase;

@Path("purchase")
public class PurchaseResource {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public ArrayList<Purchase> getAllPurchase(){
		
		System.out.println("called getAllPurchase()");
		
		PurchaseDao  purchaseDao = new PurchaseDao();
		
		Query query = purchaseDao.query("SELECT a FROM Purchase a");
		
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		purchaseList = query.getResultList();

		return (ArrayList<Purchase>) purchaseList;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createPurchase(Purchase purchase){
		
		if(!purchase.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			
			PurchaseDao purchaseDao = new PurchaseDao();
			
			purchaseDao.save(purchase);
			
			String json = "{ \"result\": \"Purchase successfully added with id = " + purchase.getPurchaseId() + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateProduct(@PathParam("id") int id,Purchase purchase){
		
		
		if(!purchase.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			
			PurchaseDao purchaseDao = new PurchaseDao();
			
			Purchase purchaseObject = purchaseDao.getPurchase(id);
			
			if(purchaseObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"purchaseId does not exist\"}").build();
			}
			
			purchaseObject.setDate(purchase.getDate());
			purchaseObject.setPaymentData(purchase.getPaymentData());
			purchaseObject.setCustomer(purchase.getCustomer());
			purchaseObject.setProducts(purchase.getProducts());
			
			purchaseDao.save(purchaseObject);
			
			String json = "{ \"result\": \"Purchase successfully updated with id = " + purchaseObject.getPurchaseId() + "\"}";
						
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteProduct(@PathParam("id") int id){
		
		
		PurchaseDao purchaseDao = new PurchaseDao();
		
		Purchase purchaseObject = purchaseDao.getPurchase(id);
		
		if(purchaseObject == null){
			return Response.status(Response.Status.NO_CONTENT).entity("{result : purchaseId does not exist}").build();
		}
		
		purchaseDao.delete(purchaseObject);
		
		String json = "{ \"result\": \"Purchase successfully deleted with id = " + id + "\"}";
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();	
	}		
	

}
