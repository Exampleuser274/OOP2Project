package data;

public class Employee extends Account {

	

	String employmentType;

	public Employee(int id, String firstName, String lastName, String employmentType) {
		super(id, firstName, lastName);
		this.employmentType = employmentType;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nEmployment Type: " + employmentType;
	}
}
