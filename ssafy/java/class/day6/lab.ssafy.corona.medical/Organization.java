package lab.ssafy.corona.medical;

public class Organization {
	private String name;
	private int employeeCount;
	
	public Organization() {};
	
	public Organization(String name, int employeeCount) {
		this.name = name;
		this.employeeCount = employeeCount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
}
