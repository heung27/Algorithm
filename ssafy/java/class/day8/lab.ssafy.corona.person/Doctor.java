package lab.ssafy.corona.person;

public class Doctor extends Person {
	private String hospitalId;
	private String licenseId;
	
	public Doctor() {}
	public Doctor(String name, int age, String phone, String hospitalId, String licenseId) {
		super(name, age, phone);
		this.hospitalId = hospitalId;
		this.licenseId = licenseId;
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
}
