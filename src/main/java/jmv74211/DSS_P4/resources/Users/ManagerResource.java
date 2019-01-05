package jmv74211.DSS_P4.resources.Users;

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

import jmv74211.DSS_P4.DAO.Users.ManagerDao;
import jmv74211.DSS_P4.models.Users.Manager;

@Path("manager")
public class ManagerResource {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public String getAllManagers(){
		
		System.out.println("called getAllManagers()");
		
		ManagerDao  managersDao = new ManagerDao();
		
		Query query = managersDao.query("SELECT a FROM Manager a");
		
		List<Manager> managerList = new ArrayList<Manager>();
		managerList = query.getResultList();
		
		String json="[";
		
		for(Manager manager: managerList){
			
			json += "{ \"birthday\" : \" "+ manager.getBirthday() + " \" , \"email\" : \" " + manager.getEmail() 
			+ " \" , \"name\" : \" " + manager.getName() + " \" , \"password\" : \" " + manager.getPassword() + "\" , \"surnames\" : \" " +
					manager.getSurnames() + " \" , \"userId\" :" + manager.getUserId() + " },";
		}
		
		json = json.substring(0, json.length()-1);
		json += "]";
				
		return json;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createManager(Manager Manager){
		
		
		if(!Manager.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			ManagerDao ManagerDao = new ManagerDao();
			
			ManagerDao.save(Manager);
			
			String json = "{ \"result\": \"Manager successfully added with id = " + Manager.getUserId() + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateManager(@PathParam("id") int id,Manager Manager){
		
		
		if(!Manager.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			
			ManagerDao ManagerDao = new ManagerDao();
			
			Manager ManagerObject = ManagerDao.getManager(id);
			
			if(ManagerObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"ManagerId does not exist\"}").build();
			}
			
			ManagerObject.setName(Manager.getName());
			ManagerObject.setEmail(Manager.getEmail());
			ManagerObject.setPassword(Manager.getPassword());
			ManagerObject.setBirthday(Manager.getBirthday());
			ManagerObject.setSurnames(Manager.getSurnames());
			ManagerObject.setPharmacyManaged(Manager.getPharmacyManaged());
			
			ManagerDao.save(ManagerObject);
			
			String json = "{ \"result\": \"Manager successfully updated with id = " + ManagerObject.getUserId() + "\"}";
			
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteManager(@PathParam("id") int id){
		
	
			ManagerDao ManagerDao = new ManagerDao();
			
			Manager ManagerObject = ManagerDao.getManager(id);
			
			if(ManagerObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"managerId does not exist\"}").build();
			}
			
			ManagerDao.delete(ManagerObject);
			
			String json = "{ \"result\": \"Manager successfully deleted with id = " + id + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
					
	}	

}
