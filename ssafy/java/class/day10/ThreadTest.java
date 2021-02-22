
public class ThreadTest { // 함께 실행, 대용량작업(함께 실행) => 대기시간 축소(비동기 작업)
	
	class MyJob extends Thread { // White Box Thread 내부를 내 마음대로 고칠 수 있다.
		void aa() {
			yield(); // Thread는 OS 것
		}
	}
	class MyJob1 implements Runnable { // Black Box Thread 내부를 내 마음대로 고칠 수 없다. // 별도의 클래스를 상속받게 가능. 유연함.
		public void run() {
			
		}
		void aa() {
//			yield(); // 아직 Thread가 아니기 때문에 오류
		}
	}
	public ThreadTest() {
		Thread t = new MyJob();
//		t.run(); // 일반 메소드 호출 (Thread 동작 아님)
		t.start();
		
		Runnable t1 = new MyJob1();
		Thread t2 = new Thread(t1);
		t2.start();
//		t2.stop(); // Deprecated : 사용 금지 추천
	}
	public static void main(String[] args) {
		
	}
}