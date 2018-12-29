package jmv74211.DSS_P4.DAO.Users;

import jmv74211.DSS_P4.DAO.Dao;
import jmv74211.DSS_P4.models.Users.User;

public class UserDao extends Dao<Integer,User> {
	
	public UserDao(){
		super();	
	}
	
	public void save(User User){
	
		System.out.println("A new User has been added");
		this.persist(User);
		
	}
	
	public void delete(User User){
		
		System.out.println("A User with id = " + User.getUserId() + "has been deleted");
		this.remove(User);	
	}
	
	public User getUser(int id){
		
		return this.findById(id);
	}
	
	public void updateUser(User User){
		this.update(User);
	}
	
	
}
