package com.ssafy.day7;

//class Info {
//	void pr() {
//		System.out.println("원래 기능");
//	}
//}

interface Info {
	void pr();
}

public class InnerTest3 {
//	이름이 없는 Inner 클래스 예제
//	Info aaa = new SubInfo1();
//	class SubInfo1 implements Info {
//		public void pr() {
//			System.out.println("pr");
//		}
//	}
	Info aaa = new Info() { // 인터페이스 객체를 만드는 것이 아니라 상속 받아 재정의 한다.
		public void pr() {
			System.out.println("pr");
		}
	};
	Info aaaaa = new Info() { // ctrl + space 커맨드를 통해 자동 완성.
		@Override
		public void pr() {
			// TODO Auto-generated method stub
			
		}
	};
//	Info aaa2 = new SubInfo(); // 클래스가 아래 선언 되어도 가능
//	Info aaa3 = new SubInfo();
//	Info aaa4 = new SubInfo();
	
//	Info aaa = new Info() { // 아래 소스와 동일한 동작. 클래스의 이름이 "아우터클래스$1". 이름이 없는 InnerClass.
//		void pr() {
//			System.out.println("변경한 기능");
//		}
//	};
	
//	Info aaa = new SubInfo();
//	class SubInfo extends Info {
//		void pr() {
//			System.out.println("변경한 기능");
//		}
//	}
	
	public InnerTest3() {
//		Info info = new Info();
//		이름이 없는 로컬 Inner class 예제
		myAction(new Info() { // 이렇게도 사용가능. 이름없는 Inner class.
			public void pr() {
				System.out.println("변경한 기능");
			}
		});
		myAction(new Info() { // 이렇게도 사용가능. 이름없는 Inner class.
			public void pr() {
				System.out.println("내가 새롭게 변경한 기능");
			}
		});
//		myAction(aaa);
//		myAction(aaa);
//		myAction(aaa);
		
//		Anonymous local Inner class
		myAction(new Info() { // ctrl + space 커맨드를 통해 자동 완성. 이름이 없는 객체 생성. 인터페이스 객체가 아님. 상속받은 객체.
			@Override
			public void pr() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	void myAction(Info info) {
		info.pr();
	}
	
//	Thread trd = new MyTread();
//	class MyTread extends Thread {
//		@Override
//		public void run() {
//			System.out.println("aa");
//		}
//	}
	Thread trd = new Thread() {
		@Override
		public void run() {
			System.out.println("aa");
		}
	};
	void aaaa() {
		new Thread() {
			@Override
			public void run() {
				System.out.println("aa");
			}
		}.start();
	}
	
	public static void main(String[] args) {
		new InnerTest3();
	}
}
