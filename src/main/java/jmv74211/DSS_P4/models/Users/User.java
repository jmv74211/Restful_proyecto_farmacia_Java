package jmv74211.DSS_P4.models.Users;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Table;


@Entity
@Table(name = "User")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	protected int userId;
	
	@Column(name = "email")
	protected String email;
	
	@Column(name = "password")
	protected String password;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "surnames")
	protected String surnames;
	
	@Column(name = "birthday")
	protected String birthday;

	public User(){
		
	}
	
	public User(String email, String password, String name, String surnames, String birthday) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.surnames = surnames;
		this.birthday = birthday;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public abstract boolean hasValidAttributes();
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", surnames=" + surnames + ", birthday=" + birthday + "]";
	}

}
