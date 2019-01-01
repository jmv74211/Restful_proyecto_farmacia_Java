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
import jmv74211.DSS_P4.models.Pharmacy;



@Path("pharmacy")
public class PharmacyResource {
	
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createPharmacy(Pharmacy pharmacy){
		
		System.out.println(pharmacy);
		
		if(!pharmacy.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			PharmacyDao pharmacyDao = new PharmacyDao();
			
			pharmacyDao.save(pharmacy);
			
			String json = "{ result: Pharmacy successfully added with id = " + pharmacy.getId() + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}		
	}
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateProduct(@PathParam("id") int id,Pharmacy pharmacy){
		
		
		if(!pharmacy.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			PharmacyDao pharmacyDao = new PharmacyDao();
			
			Pharmacy pharmacyObject = pharmacyDao.getPharmacy(id);
			
			if(pharmacyObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{result : pharmacyId does not exist}").build();
			}
			
			pharmacyObject.setLatitude(pharmacy.getLatitude());
			pharmacyObject.setLength(pharmacy.getLength());
			pharmacyObject.setManager(pharmacy.getManager());
			pharmacyObject.setName(pharmacy.getName());
			
			pharmacyDao.save(pharmacyObject);
			
			String json = "{ result: Pharmacy successfully updated with id = " + pharmacyObject.getId() + "}";
						
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteProduct(@PathParam("id") int id){
		
		
		PharmacyDao pharmacyDao = new PharmacyDao();
		
		Pharmacy pharmacyObject = pharmacyDao.getPharmacy(id);
		
		if(pharmacyObject == null){
			return Response.status(Response.Status.NO_CONTENT).entity("{result : pharmacyId does not exist}").build();
		}
		
		pharmacyDao.delete(pharmacyObject);
		
		String json = "{ result: Pharmacy successfully deleted with id = " + id + "}";
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();	
	}
	
	
	

}
