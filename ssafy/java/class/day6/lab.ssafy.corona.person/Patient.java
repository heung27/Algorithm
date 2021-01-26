package lab.ssafy.corona.person;

public class Patient extends Person {
	private String diseaseName;
	private String hospitalId;
	private boolean isCorona;
	
	public Patient() {}
	public Patient(String name, int age, String phone, String diseaseName, String hospitalId, boolean isCorona) {
		super(name, age, phone);
		this.diseaseName = diseaseName;
		this.hospitalId = hospitalId;
		this.isCorona = isCorona;
	}
	
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public boolean isCorona() {
		return isCorona;
	}
	public void setCorona(boolean isCorona) {
		this.isCorona = isCorona;
	}
}
