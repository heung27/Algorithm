package lab.ssafy.corona.medical;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import lab.ssafy.corona.person.Patient;

public class CDC extends Organization {
	private List<Hospital> hospitalList;
//	private List<Patient> patientList;
	private Set<Patient> patientList;
	
	public CDC() {}
	public CDC(String name, int employeeCount, List<Hospital> hospitalList, Set<Patient> patientList) {
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
	public Set<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}
	
	public void about() {
		System.out.println("Organization - CDC " + super.getName() );
	}
	
	public void printPatientList() {
		Iterator<Patient> itr = patientList.iterator();
		while(itr.hasNext()){
			Patient p = itr.next();
		    System.out.println(p);          
		}
	}
}
