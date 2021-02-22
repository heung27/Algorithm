package com.ssafy.corona.medical;

public class Organization implements Comparable<Organization>{
	private String name;
	private int employeeCount;
	
	public Organization() {};
	public Organization(String name, int employeeCount) {
		setName(name);
		setEmployeeCount(employeeCount);
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
	@Override
	public int hashCode() {
		final int prime=31;
		int result=1;
		result=prime*result+((name == null)? 0:name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(!(obj instanceof Organization)) return false;
		Organization other=(Organization)obj;
		if(name==null){
			if(other.name!=null){
				return false;
			}
		}else if(!name.equals(other.name)){
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(getName()).append("\t")
		.append(getEmployeeCount());
		return sb.toString();
	}
	@Override
	public int compareTo(Organization o) {
		return this.name.compareTo(o.getName());
	}
}