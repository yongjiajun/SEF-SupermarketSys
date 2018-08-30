package model.people;

public abstract class Employee {

	private String employeeID, employeeFName, employeeLName;
	protected String employeePIN;

	public Employee(String employeeID, String employeePIN, String employeeFName, String employeeLName) {
		this.employeeID = employeeID;
		this.employeePIN = employeePIN;
		this.employeeFName = employeeFName;
		this.employeeLName = employeeLName;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getEmployeePIN() {
		return employeePIN;
	}

	public String getEmployeeFName() {
		return employeeFName;
	}

	public String getEmployeeLName() {
		return employeeLName;
	}

}
