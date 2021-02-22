
public class ThreadTest3 {
	class Task extends Thread {
		int num;
		boolean onAir = true;
		
		public void run() {
			while (onAir) {
				// todo
				//
//				조건 만족하면 종료
				if (num > 10) break;
			}
		}
		
//		동기화 메소드, 동기화 메소드 병행 안됨
		// aa - aa, aa - bb
		// aa - cc 병행 가능
		
//		듀얼 CPU, 쿼드 CPU 사용하면 동기화 보장 안됨
//		서버 분산처리 1CPU, 5CPU 동작 => 자원 별도 관리 웹서버에서는 동기화 지원 안됨
	}
	
	synchronized void aa() { // 동기화 영역은 관리 비용이 비싸므로 영역을 최소화 한다.
//		보호되지 않는 영역
		synchronized (this) {
			
		}
//		보호되지 않는 영역
	}
	
	synchronized void bb() {
		
	}
	
	void cc() {
		
	}
	
	public ThreadTest3() {
		Task t = new Task();
		t.start();
		// 쓰레드 멈춤
//		t.stop();
//		t.interrupted(); 왠만하면 사용 x
		t.onAir = false; // 논리적으로 제어 (제어 변수 사용)
		
	}
	
	public static void main(String[] args) {
		new ThreadTest3();
	}
}
