package com.ssafy.corona.medical;

public class CDC extends Organization {
	private String region;
	
	public CDC() {}
	public CDC(String name, int employeeCount, String region) {
		super(name, employeeCount);
		setRegion(region);
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getRegion());
		return sb.toString();
	}
}