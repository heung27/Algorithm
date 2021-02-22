package com.ssafy.corona.person;

public class Doctor extends Person{
	private String hospitalId;
	private String licenseId;
	
	public Doctor() {}
	public Doctor(String name, int age, String phone, String hospitalId, String licenseId) {
		super(name, age, phone);
		setHospitalId(hospitalId);
		setLicenseId(licenseId);
	}
	
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getHospitalId()).append("\t")
		  .append(getLicenseId());
		return sb.toString();
	}
}	
