package com.ssafy.test;

public class FinalTest {
	public static void main(String[] args) {
		// final 키워드
//		1. 클래스 앞에 선언
//		2. 메소드 앞에 선언
//		상속
//		3. 변수 앞에 선언
//		
//		int max = 10;
//		max = 30;
//		max = 50;
		
		final int JUMSUMAX = 100; // final 변수는 모두 대문자를 권장 (두 개 이상의 단어로 구성된 이름은 중간에 _사용)
		
//		JUMSUMAX = 50;
		
		final int MAX; // 지역 변수 적용, 초기화 안 해도 에러 x
//		System.out.println(MAX); 에러
		
		final Sam sam = new Sam(); // 객체가 fianl(새로운 객체 할당 x), 객체가 가지고 있는 데이터는 변경 가능
		sam.name = "ssafy";
		sam.name = "algo";
		
		Sam sam1 = new Sam();
		
//		sam = sam1; 에러
	}
}

class Sam {
	String name;
}

class Data {
//	int max; // 멤버 변수는 자동으로 초기화 값이 들어간다. 
	final int MAX = 100; // 멤버 변수에 적용, 반드시 초기화가 필요(생성자에서도 초기화 가능)
	
	void f() {
		int a;
		a = 10;
		ff(a);
		ff(5);
		ff(9);
	}
	
	void ff(final int num) {
//		이 메소드 안에서는 num 받아오지만 변경되면 안된다.
//		num++; 에러
//		가공
	}
}