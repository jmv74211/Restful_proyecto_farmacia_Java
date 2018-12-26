package jmv74211.DSS_P4.models.Users;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Administrator extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adminId")
	private int adminId;

	public Administrator() {
		super();
		
	}

	public Administrator( String email, String password, String name, String surnames, String birthday) {
		super(email, password, name, surnames, birthday);
		
	}

	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", "+ super.toString() + "]";
	}
	
	
	
}
