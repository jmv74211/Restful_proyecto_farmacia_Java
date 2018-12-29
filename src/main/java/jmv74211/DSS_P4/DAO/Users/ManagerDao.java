package jmv74211.DSS_P4.DAO.Users;

import jmv74211.DSS_P4.DAO.Dao;
import jmv74211.DSS_P4.models.Users.Manager;;

public class ManagerDao extends Dao<Integer,Manager> {
	
	public ManagerDao(){
		super();	
	}
	
	public void save(Manager manager){
	
		System.out.println("A new manager has been added");
		this.persist(manager);
		
	}
	
	public void delete(Manager manager){
		
		System.out.println("A manager with id = " + manager.getUserId() + "has been deleted");
		this.remove(manager);	
	}
	
	public Manager getManager(int id){
		
		return this.findById(id);
	}
	
	public void updateManager(Manager manager){
		this.update(manager);
	}
	

}
