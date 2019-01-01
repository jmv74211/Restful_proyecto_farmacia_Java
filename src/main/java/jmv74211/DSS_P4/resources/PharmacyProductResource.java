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

import jmv74211.DSS_P4.DAO.PharmacyDao;
import jmv74211.DSS_P4.DAO.PharmacyProductDao;
import jmv74211.DSS_P4.DAO.ProductDao;
import jmv74211.DSS_P4.models.PharmacyProduct;
import jmv74211.DSS_P4.models.PharmacyProductPK;


@Path("pharmacy/{id}/products")
public class PharmacyProductResource {

	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response addProduct(PharmacyProduct pharmacyProduct){
		
		
		if(!pharmacyProduct.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			PharmacyProductDao pharmacyProductDao = new PharmacyProductDao();
			PharmacyDao pharmacyDao = new PharmacyDao();
			ProductDao productDao = new ProductDao();
			
			pharmacyProductDao.addProduct(pharmacyDao.getPharmacy(pharmacyProduct.getPharmacyId()), 
					productDao.getProduct(pharmacyProduct.getProductId()),pharmacyProduct.getQuantity());			
			
			String json = "{ result: It has been successfully added " + pharmacyProduct.getQuantity() + " products with id = " + 
					pharmacyProduct.getProductId() + " to the pharmacy with id = " + pharmacyProduct.getPharmacyId() + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@POST
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updatePharmacyProduct(@PathParam("id") int id,PharmacyProduct pharmacyProduct){
		
		
		if(!pharmacyProduct.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			PharmacyProductDao pharmacyProductDao = new PharmacyProductDao();
			
			PharmacyProductPK pk = new PharmacyProductPK(pharmacyProduct.getPharmacyId(),pharmacyProduct.getProductId());
			
			PharmacyProduct pharmacyProductObject = pharmacyProductDao.getPharmacyProduct(pk);
			
			if(pharmacyProductObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{result : Wrong data }").build();
			}
			
			pharmacyProductObject.setQuantity(pharmacyProduct.getQuantity());
			
			pharmacyProductDao.save(pharmacyProductObject);
			
			String json = "{ result: It has been successfully updated. Now the pharmacy with id = " + pharmacyProduct.getPharmacyId() + " has " +  
			pharmacyProduct.getQuantity() + "products with id = " + pharmacyProduct.getProductId() + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@DELETE
	@Path("/{productId}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deletePharmacyProduct(@PathParam("id") int id, @PathParam("productId") int productId ){
		
	
		PharmacyProductDao pharmacyProductDao = new PharmacyProductDao();
		
		PharmacyProductPK pk = new PharmacyProductPK(id,productId);
		
		PharmacyProduct pharmacyProductObject = pharmacyProductDao.getPharmacyProduct(pk);
		
		if(pharmacyProductObject == null){
			return Response.status(Response.Status.NO_CONTENT).entity("{result : Wrong id params}").build();
		}
		
		pharmacyProductDao.delete(pharmacyProductObject);
		
		String json = "{ result: It has been successfully deleted. Now the pharmacy with id = " + pharmacyProductObject.getPharmacyId() + 
				" does not have any product with id = " + pharmacyProductObject.getProductId() + "}";
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
					
	}
	
	
}
