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

import jmv74211.DSS_P4.DAO.DepartmentDao;
import jmv74211.DSS_P4.models.Department;


@Path("/department")
public class DepartmentResource {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public ArrayList<Department> getAllDepartments(){
		
		System.out.println("called getAllDepartments()");
		
		DepartmentDao  departmentDao = new DepartmentDao();
		
		Query query = departmentDao.query("SELECT a FROM Department a");
		
		List<Department> departmentList = new ArrayList<Department>();
		departmentList = query.getResultList();

		return (ArrayList<Department>) departmentList;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PUT
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response createDepartment(Department department){
		
		if(!department.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			
			DepartmentDao departmentDao = new DepartmentDao();
			
			departmentDao.save(department);
			
			String json = "{ \"result\": \"Department successfully added with id = " + department + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@POST
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response updateCustomer(@PathParam("id") int id,Department department){
		
		
		if(!department.hasValidAttributes()){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data parameters\"}").build();
		}
		else{
			
			DepartmentDao departmentDao = new DepartmentDao();
			
			Department departmentObject = departmentDao.getDepartment(id);
			
			departmentObject.setName(department.getName());
			
			departmentDao.save(departmentObject);
			
			String json = "{ \"result\": \"Department successfully updated with id = " + departmentObject.getDepartmentId() + "\"}";
			
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@DELETE
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response deleteCustomer(@PathParam("id") int id){
		
	
			DepartmentDao departmentDao = new DepartmentDao();;
			
			Department departmentObject = departmentDao.getDepartment(id);
			
			if(departmentObject == null){
				return Response.status(Response.Status.NO_CONTENT).entity("{\"result\" : \"CustomerId does not exist\"}").build();
			}
			
			departmentDao.delete(departmentObject);
			
			String json = "{ \"result\": \"Department successfully deleted with id = " + id + "\"}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
					
	}	

}
