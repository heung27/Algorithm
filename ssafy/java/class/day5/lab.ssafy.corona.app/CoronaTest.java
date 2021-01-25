package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.Corona;
import lab.ssafy.corona.virus.Virus;

public class CoronaTest {

//	public static void main(String[] args) {
//		Virus virus = new Virus();
//		virus.setName("MERS");
//		virus.setLevel(5);
//		
//		Corona corona = new Corona();
//		corona.setName("Corona");
//		corona.setLevel(8);
//		corona.setSpreadSpeed(200);
//	}

//	public static void main(String[] args) {
//		Corona corona = new Corona();
//		corona.showInfo();
//	}
	
	public static void main(String[] args) {
		Corona corona = new Corona("Corona", 8, 200);
//		corona.setName("코로나");
//		corona.setLevel(5);
//		corona.setSpreadSpeed(20);
		corona.showInfo();
	}
}