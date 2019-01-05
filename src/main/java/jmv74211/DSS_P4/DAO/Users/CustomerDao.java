package jmv74211.DSS_P4.DAO.Users;

import jmv74211.DSS_P4.DAO.Dao;
import jmv74211.DSS_P4.models.Users.Customer;


public class CustomerDao extends Dao<Integer,Customer> {
	
	public CustomerDao(){
		super();	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void save(Customer customer){
	
		System.out.println("A new customer has been added");
		this.persist(customer);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void delete(Customer customer){
		
		System.out.println("A customer with id = " + customer.getUserId() + "has been deleted");
		this.remove(customer);	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Customer getCustomer(int id){
		
		return this.findById(id);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void updateCustomer(Customer customer){
		this.update(customer);
	}

}
