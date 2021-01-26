package com.ssafy.day6;

class TA {
	void a(int i) {
		System.out.println("TA a 매개변수 1개");
	}
}

class TB extends TA {
	void b() {
		System.out.println("TB b 매개변수 없음");
	}
}

class TC extends TB {
	void a() { // 오버로딩 개념, TC에 추가된 일반 메소드
		System.out.println("TC a 매개변수 없음");
	}
	void b(int i) { // 오버로딩 개념, TC에 추가된 일반 메소드
		System.out.println("TC b 매개변수 1개");
	}
}

class TD extends TC {
	void a(int i) { // 재정의 메소드
		System.out.println("TD a 매개변수 1개 재정의");
	}
	void b() { // 재정의 메소드 TB의 b 재정의
		System.out.println("TD b 매개변수 없음 재정의");
	}
}

class TE extends TD {
	void a() { // 재정의 TC 클래스의 메소드 재정의
		System.out.println("TE a 매개변수 없음 재정의");
	}
	void b() {
		System.out.println("TB b 매개변수 없음 재정의");
	}
}

public class Test2 {

	public Test2() {
//		TA ta = new TC();
//		ta.a(); // 에러
//		
//		TC tc = new TE();
//		tc.b(3);
		
		TB tb = new TD();
		tb.a(1);
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}
