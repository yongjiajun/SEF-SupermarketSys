package model;

public abstract class Employee {

	protected String username, password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		// for changing password??
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
