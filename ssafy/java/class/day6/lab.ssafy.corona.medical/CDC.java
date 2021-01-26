package lab.ssafy.corona.medical;

import java.util.List;

import lab.ssafy.corona.person.Patient;

public class CDC extends Organization {
	private List<Hospital> hospitalList;
	private List<Patient> patientList;
	
	public CDC() {}
	public CDC(String name, int employeeCount, List<Hospital> hospitalList, List<Patient> patientList) {
		super(name, employeeCount);
		this.hospitalList = hospitalList;
		this.patientList = patientList;
	}
	
	public List<Hospital> getHospitalList() {
		return hospitalList;
	}
	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}
	public List<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
}
