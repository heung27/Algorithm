package lab.ssafy.corona.medical;

import lab.ssafy.corona.person.Patient;

public class Hospital extends Organization implements MedicalAction {
	private CDC cdc;
	
	private String hospitalId;
	private int roomTotalCount;
	private int roomEmptyCount;

	public Hospital() {}
	public Hospital(String name, int employeeCount, String hospitalId, int roomTotalCount, int roomEmptyCount) {
		super(name, employeeCount);
		this.hospitalId = hospitalId;
		this.roomTotalCount = roomTotalCount;
		this.roomEmptyCount = roomEmptyCount;
	}
	
	public CDC getCdc() {
		return cdc;
	}
	public void setCdc(CDC cdc) {
		this.cdc = cdc;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getRoomTotalCount() {
		return roomTotalCount;
	}
	public void setRoomTotalCount(int roomTotalCount) {
		this.roomTotalCount = roomTotalCount;
	}
	public int getRoomEmptyCount() {
		return roomEmptyCount;
	}
	public void setRoomEmptyCount(int roomEmptyCount) {
		this.roomEmptyCount = roomEmptyCount;
	}
	public void about() {
		System.out.println("We are Hospital : " + super.getName());
	}
	@Override
	public void addPatient(Patient p) throws NotCoronaException {		
		if( ! p.isCorona() ) throw new NotCoronaException("NotCorona");
		cdc.getPatientList().add(p);
	}
	@Override
	public void removePatient(Patient p) {
		cdc.getPatientList().remove(p);
	}
}
