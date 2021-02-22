package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaThread;

public class CoronaThreadInterruptTest {
	public static void main(String[] args) {
		CoronaThread t = new CoronaThread(2020);
		t.start();
		t.interrupt();
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Thread End!!");
	}
}
