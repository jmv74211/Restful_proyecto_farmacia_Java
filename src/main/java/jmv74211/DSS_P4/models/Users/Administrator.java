package jmv74211.DSS_P4.models.Users;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Administrator extends User {

	public Administrator() {
		super();
		
	}

	public Administrator( String email, String password, String name, String surnames, String birthday) {
		super(email, password, name, surnames, birthday);
		
	}

	@Override
	public String toString() {
		return "Administrator [ " + super.toString() + "]";
	}
	
	
	
}
