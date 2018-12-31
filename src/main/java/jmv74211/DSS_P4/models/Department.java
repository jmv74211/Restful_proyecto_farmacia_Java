package jmv74211.DSS_P4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentId")
	private int departmentId;
	
	@Column(name = "name")
	private String name;

	
	public Department(){
		
	}
	
	public Department(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasValidAttributes(){
		
		if(this == null || this.name == null )
			
			return false;
		
		else
			return true;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + "]";
	}	
		
}