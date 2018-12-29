package jmv74211.DSS_P4.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jmv74211.DSS_P4.DAO.Users.CustomerDao;
import jmv74211.DSS_P4.models.Users.Customer;


@Path("user")
public class UserResource {
	  	  
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createCustomer(Customer customer){
		
		
		if(customer == null || customer.getName() == null || customer.getSurnames() == null
				|| customer.getCreditCardNumber()==null || customer.getBirthday() == null 
				|| customer.getEmail()==null || customer.getPassword() == null){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			CustomerDao customerDao = new CustomerDao();
			
			customerDao.save(customer);
			
			String json = "{ result: User successfully added with id = " + customer.getUserId() + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}	  
}
