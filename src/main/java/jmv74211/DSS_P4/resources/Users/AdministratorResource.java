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

import jmv74211.DSS_P4.DAO.Users.AdministratorDao;
import jmv74211.DSS_P4.models.Users.Administrator;

@Path("administrator")
public class AdministratorResource {
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public ArrayList<Administrator> getAllAdministrators(){
		
		System.out.println("called getAllAdministrators()");
		
		AdministratorDao  administratorsDao = new AdministratorDao();
		
		Query query = administratorsDao.query("SELECT a FROM Administrator a");
		
		List<Administrator> adminList = new ArrayList<Administrator>();
		adminList = query.getResultList();
		
		return (ArrayList<Administrator>) adminList;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	@Consumes( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public Administrator getAdministrator(@PathParam("id") int id){
		
		System.out.println("called getAdministrator()");
		
		AdministratorDao  administratorsDao = new AdministratorDao();
		
		Query query = administratorsDao.query("SELECT a FROM Administrator a WHERE a.userId=" + id +"");
		
		List<Administrator> adminList = new ArrayList<Administrator>();
		adminList = query.getResultList();
		
		if(adminList.size() == 0)
			return new Administrator();
		
		return adminList.get(0);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createAdministrator(Administrator administrator){
		
		
		if(!administrator.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			AdministratorDao administratorDao = new AdministratorDao();
			
			administratorDao.save(administrator);
			
			String json = "{ \"result\": \"Administrator successfully added with id = " + administrator.getUserId() + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateAdministrator(@PathParam("id") int id,Administrator administrator){
		
		
		if(!administrator.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			
			AdministratorDao administratorDao = new AdministratorDao();
			
			Administrator administratorObject = administratorDao.getAdministrator(id);
			
			if(administratorObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"administratorId does not exist\"}").build();
			}
			
			administratorObject.setName(administrator.getName());
			administratorObject.setEmail(administrator.getEmail());
			administratorObject.setPassword(administrator.getPassword());
			administratorObject.setBirthday(administrator.getBirthday());
			administratorObject.setSurnames(administrator.getSurnames());
			
			administratorDao.save(administratorObject);
			
			String json = "{ \"result\": \"Administrator successfully updated with id = " + administratorObject.getUserId() + "\"}";
			
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteAdministrator(@PathParam("id") int id){
		
	
			AdministratorDao administratorDao = new AdministratorDao();
			
			Administrator administratorObject = administratorDao.getAdministrator(id);
			
			if(administratorObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"administratorId does not exist \"}").build();
			}
			
			administratorDao.delete(administratorObject);
			
			String json = "{ \"result\": \"Administrator successfully deleted with id = " + id + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
					
	}

}
