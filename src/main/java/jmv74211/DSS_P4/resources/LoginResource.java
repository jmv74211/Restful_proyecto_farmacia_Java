package jmv74211.DSS_P4.resources;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import jmv74211.DSS_P4.DAO.Users.UserDao;


@Path("login")
public class LoginResource {

    private String email;

    private String password;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "LoginResource [email=" + email + ", password=" + password + "]";
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@POST
	@Produces( {MediaType.APPLICATION_JSON} )
	@Consumes( {MediaType.APPLICATION_JSON} )
	public Response login(LoginResource loginObject){

		
		System.out.println(loginObject);
		
		if(loginObject == null || loginObject.getEmail() == null || loginObject.getPassword() == null){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"result\" : \"Wrong data, need email and password\"}").build();
		}
		else{
			
			boolean check = this.checkCredentials(loginObject.getEmail(), loginObject.getPassword());
			
			String json = "{ \"result\":" + check + "}";
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}	
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getEmail() {
		return email;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setEmail(String email) {
		this.email = email;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getPassword() {
		return password;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setPassword(String pasword) {
		this.password = pasword;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean checkCredentials(String email, String password){
		
		UserDao userDao = new UserDao();
		
		Query query = userDao.query("SELECT name,birthday FROM User WHERE email='"+email+"' AND password='" + password + "'");
		System.out.println(query.getResultList().getClass());
		System.out.println(query.getResultList().size());
		
		return query.getResultList().size() > 0 ? true : false;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
