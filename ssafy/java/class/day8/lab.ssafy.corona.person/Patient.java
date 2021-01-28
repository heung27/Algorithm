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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName() + " ");
		sb.append(super.getPhone() + " ");
		if( isCorona ) sb.append("코로나 환자입니다.");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		Patient p = (Patient)o;
		if( this.getName().equals(p.getName()) && this.getPhone().equals(p.getPhone()) ){
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + this.getName().hashCode();
		hash = 31 * hash + this.getPhone().hashCode();
		return hash;
	}
	
}
