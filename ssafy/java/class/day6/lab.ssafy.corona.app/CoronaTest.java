package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.Virus;
import lab.ssafy.corona.virus.Corona;

public class CoronaTest {
	public static void main(String[] args) {
//		Virus virus = new Virus("UNKNOWN", 5);
//		System.out.println(virus);
//		
//		Corona corona = new Corona("Corona", 8, 200);
//		System.out.println(corona);
		

//		Corona에 재정의 되어있는 toString()이 호출 됨
		Virus virus = new Corona("Corona", 8, 200);
		System.out.println(virus);
		
//		virus에 정의되어 있는 메소드만 호출 가능
//		virus.spreadSpeed; 에러
//		virus.showInfo(); 에러
	}
}
