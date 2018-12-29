package jmv74211.DSS_P4.DAO.Users;

import jmv74211.DSS_P4.DAO.Dao;
import jmv74211.DSS_P4.models.Users.Administrator;


public class AdministratorDao extends Dao<Integer,Administrator> {
	
	public AdministratorDao(){
		super();	
	}
	
	public void save(Administrator administrator){
	
		System.out.println("A new administrator has been added");
		this.persist(administrator);
		
	}
	
	public void delete(Administrator administrator){
		
		System.out.println("An administrator with id = " + administrator.getUserId() + "has been deleted");
		this.remove(administrator);	
	}
	
	public Administrator getAdministrator(int id){
		
		return this.findById(id);
	}
	
	public void updateAdministrator(Administrator administrator){
		this.update(administrator);
	}
	

}
