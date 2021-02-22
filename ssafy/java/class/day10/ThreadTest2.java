

public class ThreadTest2 { // 함께 실행, 대용량작업(함께 실행) => 대기시간 축소(비동기 작업)
	
	class MyJob extends Thread { // White Box Thread 내부를 내 마음대로 고칠 수 있다.
		public void run() {
//			작업, 병행하거나, 오랜시간 작업
//			aa();
//			병행의 반복작업
			int num = 0;
			while (true) {
//				작업1 반복작업
				aa(); // 계속 CPU 점유
				yield();
				try {
					Thread.sleep(1); // 아주 짧은 시간 텀을 줌
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (num >= 110) {
					break;
				}
			}
		}
		
		void aa() {
//			오랜작업
		}
	}

	public ThreadTest2() {
		Thread t = new MyJob();
		t.start();
		System.out.println("t와 상관없이 할일");
		
//		합을 구하는 쓰레드
//		1반 합, 2반 합, 3반 합 - 쓰레드 : 인자 반점수
//		평균을 구하는 쓰레드 (합이 구해져 있어야 평균을 구함, 합을 구하는 쓰레드.join 메소드를 통해 합 쓰레드가 완료되면 수행) - 일반 메소드화
	}
	
	public static void main(String[] args) {
		new ThreadTest2();
	}
}