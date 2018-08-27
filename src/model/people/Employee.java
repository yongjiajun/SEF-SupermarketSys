package model.people;

public abstract class Employee {

	private String employeeFName;
	private String employeeLName;
	private String employeeID;
	protected String employeePIN;

	public Employee(String employeeFName, String employeeLName, String employeeID, String employeePIN)
	{
		this.employeeFName = employeeFName;
		this.employeeLName = employeeLName;
		this.employeeID = employeeID;
		this.employeePIN = employeePIN;
	}
	
	public String getEmployeeFName() {
		return employeeFName;
	}
	
	public String getEmployeeLName() {
		return employeeLName;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}

	public String getEmployeePIN() {
		return employeePIN;
	}

}
