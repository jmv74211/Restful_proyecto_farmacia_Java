package jmv74211.DSS_P4.models.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Customer extends User {
	
	@Column(name = "creditCardNumber")
	private String creditCardNumber;

	
	public Customer() {
		super();
	}
	
	public Customer(String email, String password, String name, String surnames, String birthday, String creditCardNumber) {
		super(email, password, name, surnames, birthday);
		// TODO Auto-generated constructor stub
		this.creditCardNumber=creditCardNumber;
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String toString() {
		return "Customer [creditCardNumber=" + creditCardNumber + super.toString() + "]";
	}
	
	
}
