
// 람다 가능한 interface. 1개의 추상 메소드만 가지고 있는 인터페이스입니다.
@FunctionalInterface
interface Sub1 {
	void call(String s);
}

interface Sub2 {
	int call(String s);
}

public class LamdaTest1 {
//	주석을 해제하고 잘못된 부분을 수정해서 정상적으로 동작하게 하라
	
//	MySub1 sub1 = new MySub1();
//	class MySub1 implements Sub1 {
//		@Override
//		public void call(String msg) {
//			System.out.println("a");
//			System.out.println("hello " + msg);
//		}
//	}
	
	public static void main(String[] args) {
		
		//	java -> , javaScript => (애로우 함수)
		//	람다로 변경 JDK 8.0 추가된 기능
		//	float a = 10.f; 유추할 수 있다.
		
//		반환되는 타입이 있는 경우 && 명령문이 하나인 경우 : return을 삭제해야 한다.
		Sub2 subb2 = msg -> msg.equals("A") ? 1 : 10;
		
//		실행되는 명령문이 1개인 경우 {}을 생략할 수 있다.
		Sub1 sub1 = msg -> System.out.println("저장" + msg);
		Sub1 sub2 = msg -> System.out.println("설정" + msg);
		Sub1 sub3 = msg -> System.out.println("종료" + msg);
		
//		만약에 매개변수가 1개이면 괄호를 생략할 수 있다.
//		0개 이거나 2개 이상은 생략하면 안된다.
//		Sub1 sub1 = msg -> {
//			System.out.println("a");
//			System.out.println("hello " + msg);
//		};
		
//	 	매개변수의 타입을 생략할 수 있다.
//		Sub1 sub1 = (msg) -> { // 람다
//				System.out.println("a");
//				System.out.println("hello " + msg);
//		};
		
		
		
//		Sub1 sub1 = new Sub1() { // 어너미어스 inner class
//			@Override
//			public void call(String msg) {
//				System.out.println("a");
//				System.out.println("hello " + msg);
//			}
//		};
//		
//		Sub1 sub2 = new Sub1() { // 어너미어스 inner class
//			@Override
//			public void call(String msg) {
//				System.out.println("a");
//				System.out.println("goodbye " + msg);
//			}
//		};
		
		sub1.call("ssafy");
		sub1.call("java");
//		
//		sub2.call("ssafy");
//		sub2.call("java");
	}
}
