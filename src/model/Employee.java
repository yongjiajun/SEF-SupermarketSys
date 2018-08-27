package model;

public abstract class Employee {

	protected String username, pin;

	public String getUsername() {
		return username;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
		// for changing password??
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
