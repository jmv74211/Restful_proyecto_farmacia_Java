package jmv74211.DSS_P4.models.Users;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import jmv74211.DSS_P4.models.Pharmacy;


@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Manager extends User {
	
	@OneToOne(mappedBy = "manager", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
	private Pharmacy pharmacyManaged;

	public Manager() {
		super();
	}

	public Manager(String email, String password, String name, String surnames, String birthday) {
		super(email, password, name, surnames, birthday);
	}
	
	public Pharmacy getPharmacyManaged() {
		return pharmacyManaged;
	}

	public void setPharmacyManaged(Pharmacy pharmarcyManaged) {
		this.pharmacyManaged = pharmarcyManaged;
	}

	public boolean hasValidAttributes(){
	
		if(this == null || this.getName() == null || this.getSurnames() == null
				|| this.getPharmacyManaged() == null || this.getBirthday() == null 
				|| this.getEmail()==null || this.getPassword() == null)
			
			return false;
		
		else
			return true;
	}
	
	@Override
	public String toString() {
		return "Manager [pharmacyManaged=" + pharmacyManaged + "]";
	}

	
	


	
	
	
	
}
