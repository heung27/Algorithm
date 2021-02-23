package lab.ssafy.corona.medical;

import lab.ssafy.corona.person.Patient;

public interface MedicalAction {
	void addPatient(Patient p) throws NotCoronaException; // 자식이 예외를 던지면 부모도 해줘야함
	void removePatient(Patient p);
}
