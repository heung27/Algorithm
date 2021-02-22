package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.Cell;
import lab.ssafy.corona.virus.CoronaThread;
import lab.ssafy.corona.virus.MedicineThread;

public class MedicineThreadSyncTest {
	
	public static void main(String[] args) {
//		Cell cell = new Cell();
//		
//		for( int i=0; i< 10; i++) {
//			MedicineThread t = new MedicineThread(cell);
//			t.start();
//		}
//
//		try {
//			Thread.sleep(500);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Cell cell = new Cell();
		
		for( int i=0; i< 10; i++) {
			MedicineThread t = new MedicineThread(cell);
			t.start();
		}
		
		for( int i=0; i< 10; i++) {
			CoronaThread t = new CoronaThread(cell);
			t.start();
		}

		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
