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
            fetch = FetchType.LAZY, optional = false)
	private Pharmacy pharmacyManaged;

	public Manager() {
		super();
	}

	public Manager(String email, String password, String name, String surnames, String birthday) {
		super(email, password, name, surnames, birthday);
	}
	
	public Pharmacy getPharmarcyManaged() {
		return pharmacyManaged;
	}

	public void setPharmarcyManaged(Pharmacy pharmarcyManaged) {
		this.pharmacyManaged = pharmarcyManaged;
	}

	@Override
	public String toString() {
		return "Manager [pharmacyManaged=" + pharmacyManaged + "]";
	}

	
	


	
	
	
	
}
