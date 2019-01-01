package jmv74211.DSS_P4.resources.Users;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jmv74211.DSS_P4.DAO.Users.AdministratorDao;
import jmv74211.DSS_P4.models.Users.Administrator;

@Path("administrator")
public class AdministratorResource {
	
	
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createAdministrator(Administrator administrator){
		
		
		if(!administrator.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			AdministratorDao administratorDao = new AdministratorDao();
			
			administratorDao.save(administrator);
			
			String json = "{ result: Administrator successfully added with id = " + administrator.getUserId() + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateAdministrator(@PathParam("id") int id,Administrator administrator){
		
		
		if(!administrator.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			AdministratorDao administratorDao = new AdministratorDao();
			
			Administrator administratorObject = administratorDao.getAdministrator(id);
			
			if(administratorObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{result : administratorId does not exist}").build();
			}
			
			administratorObject.setName(administrator.getName());
			administratorObject.setEmail(administrator.getEmail());
			administratorObject.setPassword(administrator.getPassword());
			administratorObject.setBirthday(administrator.getBirthday());
			administratorObject.setSurnames(administrator.getSurnames());
			
			administratorDao.save(administratorObject);
			
			String json = "{ result: Administrator successfully updated with id = " + administratorObject.getUserId() + "}";
			
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteAdministrator(@PathParam("id") int id){
		
	
			AdministratorDao administratorDao = new AdministratorDao();
			
			Administrator administratorObject = administratorDao.getAdministrator(id);
			
			if(administratorObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{result : administratorId does not exist}").build();
			}
			
			administratorDao.delete(administratorObject);
			
			String json = "{ result: Administrator successfully deleted with id = " + id + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
					
	}

}
