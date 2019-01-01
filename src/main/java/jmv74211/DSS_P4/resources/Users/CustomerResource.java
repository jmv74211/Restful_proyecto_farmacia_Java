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

import jmv74211.DSS_P4.DAO.Users.CustomerDao;
import jmv74211.DSS_P4.models.Users.Customer;


@Path("user")
public class CustomerResource {
	  	  
	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createCustomer(Customer customer){
		
		
		if(!customer.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			CustomerDao customerDao = new CustomerDao();
			
			customerDao.save(customer);
			
			String json = "{ result: User successfully added with id = " + customer.getUserId() + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateCustomer(@PathParam("id") int id,Customer customer){
		
		
		if(!customer.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{result : Wrong data parameters}").build();
		}
		else{
			
			CustomerDao customerDao = new CustomerDao();
			
			Customer customerObject = customerDao.getCustomer(id);
			
			if(customerObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{result : CustomerId does not exist}").build();
			}
			
			customerObject.setName(customer.getName());
			customerObject.setEmail(customer.getEmail());
			customerObject.setPassword(customer.getPassword());
			customerObject.setBirthday(customer.getBirthday());
			customerObject.setSurnames(customer.getSurnames());
			customerObject.setCreditCardNumber(customer.getCreditCardNumber());
			
			customerDao.save(customerObject);
			
			String json = "{ result: User successfully updated with id = " + customerObject.getUserId() + "}";
			
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteCustomer(@PathParam("id") int id){
		
	
			CustomerDao customerDao = new CustomerDao();
			
			Customer customerObject = customerDao.getCustomer(id);
			
			if(customerObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{result : CustomerId does not exist}").build();
			}
			
			customerDao.delete(customerObject);
			
			String json = "{ result: User successfully deleted with id = " + id + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
					
	}	
		
	
}
