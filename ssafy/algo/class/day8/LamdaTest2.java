
public class LamdaTest2 {
//	Thread class Runnable interface Thread
//	MyRunnable runnable = new MyRunnable();
//	class MyRunnable implements Runnable {
//		@Override
//		public void run() {
//			System.out.println("run");
//		}
//	}
	void toDo() {
//		뭔가 무지막지한 일 하기
	}
	public LamdaTest2() {
		new Thread(() -> toDo()).start();
		
//		Thread t = new Thread(() -> toDo());
//		t.start();
		
//		Runnable runnable = () -> System.out.println("runa");
//		Thread t = new Thread(() -> aaaa());
//		t.start();
		
//		Runnable runnable = () -> System.out.println("runa");
		
//		Runnable runnable = () -> {
//			System.out.println("runa");
//		};
		
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				
//			}
//		};
		
//		Thread t = new Thread(runnable);
//		t.start(); // runnable에 정의된 함수 실행
	}

	public static void main(String[] args) {
		new LamdaTest2();
	}

}
