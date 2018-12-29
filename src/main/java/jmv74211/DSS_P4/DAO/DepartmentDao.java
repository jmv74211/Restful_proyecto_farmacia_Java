package jmv74211.DSS_P4.DAO;

import jmv74211.DSS_P4.models.Department;

public class DepartmentDao extends Dao<Integer,Department> {
	
	public DepartmentDao(){
		super();	
	}
	
	public void save(Department Department){
	
		System.out.println("A new Department has been added");
		this.persist(Department);
		
	}
	
	public void delete(Department Department){
		
		System.out.println("A Department with id = " + Department.getDepartmentId() + "has been deleted");
		this.remove(Department);	
	}
	
	public Department getDepartment(int id){
		
		return this.findById(id);
	}
	
	public void updateDepartment(Department Department){
		this.update(Department);
	}

}