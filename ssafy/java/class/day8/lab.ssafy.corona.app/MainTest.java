package lab.ssafy.corona.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lab.ssafy.corona.medical.CDC;
import lab.ssafy.corona.medical.Hospital;
import lab.ssafy.corona.medical.NotCoronaException;
import lab.ssafy.corona.person.Patient;

public class MainTest {
	public static void main(String[] args) {
		// 병원 생성
		Hospital univHospital = new Hospital("대학병원", 15, "001", 50, 10);
		Hospital localHospital = new Hospital("동네병원", 3, "901", 10, 2);
		
		// 환자 생성
		Patient p1 = new Patient("환자1", 42, "010-1111-1111", "호흡곤란", "001", true);
		Patient p2 = new Patient("환자2", 30, "010-2222-2222", "과음", "901", true);
		
		// 병원 Collection
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);
		
		// 환자 Collection
		Set<Patient> patientList = new HashSet<Patient>();
		patientList.add(p1);
		patientList.add(p2);
		
		CDC cdc = new CDC("질병관리본부", 200, hospitalList, patientList);
		cdc.about();
		
		// 병원에 cdc 연결
		univHospital.setCdc(cdc);
		localHospital.setCdc(cdc);
				
		// 새로운 환자 등록
		Patient p3 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);
//		univHospital.addPatient(p3);
//		univHospital.addPatient(p3); // 중복되는지 확인. set을 사용해 처리.
		
		try {
			univHospital.addPatient(p3);
		}catch(NotCoronaException e) {
			System.out.println("등록하려는 환자는 Corona 환자가 아닙니다.");
		}
		
		// p3 과 동일정보의 환자 p4 등록
//		Patient p4 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false); // set과 hashcode를 사용해 중복 제거
//		univHospital.addPatient(p4);
				
//		// p3 과 동일정보의 환자로 p3 삭제 시도
//		Patient p4 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);
//		univHospital.removePatient(p4);
		
		cdc.printPatientList();
		
		// 환자 리스트 csv 파일 출력
		String filePath = "c:"+File.separator+"SSAFY";
		String fileName = "CoronaPatientList.csv";
		
		try (				
			BufferedWriter writer = 
			new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream(filePath+File.separator+fileName), "MS949")); // MS949로 인코딩 (엑셀)
		){
			for( Patient p : patientList ) {
				writer.write(p.getName() + "^" + p.getAge() + "^" + p.getPhone()); // 버퍼에 데이터 입력
				writer.newLine();
			}
			writer.flush(); // 버퍼 비우기
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}