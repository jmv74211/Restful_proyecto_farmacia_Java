package jmv74211.DSS_P4.models;

public class User {
	
	private int userId;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private String surnames;
	
	private String birthday;

	public User(){
		
	}
	
	public User(int userId, String email, String password, String name, String surnames, String birthday) {
		super();
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", surnames=" + surnames + ", birthday=" + birthday + "]";
	}

}
