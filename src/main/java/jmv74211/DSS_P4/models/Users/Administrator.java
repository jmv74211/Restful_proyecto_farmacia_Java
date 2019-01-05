package jmv74211.DSS_P4.models.Users;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Administrator extends User implements Serializable {

	private static final long serialVersionUID = 1L;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Administrator() {
		super();
		
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Administrator( String email, String password, String name, String surnames, String birthday) {
		super(email, password, name, surnames, birthday);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean hasValidAttributes(){
		
		if(this == null || this.getName() == null || this.getSurnames() == null
				|| this.getBirthday() == null || this.getEmail()==null || this.getPassword() == null)
			
			return false;
		
		else
			return true;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return "Administrator [ " + super.toString() + "]";
	}
	
	
	
}
