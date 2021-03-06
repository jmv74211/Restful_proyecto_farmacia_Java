package jmv74211.DSS_P4.models.Users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Customer extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "creditCardNumber")
	private String creditCardNumber;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Customer() {
		super();
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Customer(String email, String password, String name, String surnames, String birthday, String creditCardNumber) {
		super(email, password, name, surnames, birthday);
		// TODO Auto-generated constructor stub
		this.creditCardNumber=creditCardNumber;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean hasValidAttributes(){
		
		if(this == null || this.getName() == null || this.getSurnames() == null
				|| this.getCreditCardNumber() == null || this.getBirthday() == null 
				|| this.getEmail()==null || this.getPassword() == null)
			
			return false;
		
		else
			return true;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Customer [creditCardNumber=" + creditCardNumber + super.toString() + "]";
	}
	
	
}
