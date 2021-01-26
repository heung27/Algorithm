package com.ssafy.day6;

public class OverloadingTest {
//	int sum(int a, int b) {}
//	int sum(int a, long b) {}
//	int sum(int a, int b, int c) {}
	int sum(int... arr) { //가변인자.  (배열인자)
//      배열로 인식
      int tot = 0;
      for(int i = 0; i < arr.length; i++) {
          tot += arr[i];
      }
      return tot;
	}
	
	public OverloadingTest() {
		
		String s = String.format("%s, 숫자 %d 실수 %5.3f", "ssafy", 12345, 1234.5678);
		System.out.println(s);
		
		int res = sum(1, 2);
		res = sum(2, 3, 4);
		res = sum(2, 3, 46, 67, 7, 7);
		res = sum(2);
		res = sum();
		
//		 오버로딩 규칙
//		 1. 메소드의 이름이 같다.
//		 2. within a class에서 (같은 클래스 내에서)
//		 3. 반드시 매개변수의 갯수나 타입이 틀려야 한다.
//		 4. 반환타입은 상관이 없다.
//		 5. 접근 제한자는 상관이 없다.
		
//		개발자는 힘들게 만들어서 내 클래스를 활용하는 사용자(개발자)를 편하게 사용하도록 같은 이름의 다양함 메소드 만들기
	}
	public static void main(String[] args) {
		new OverloadingTest();
	}
}
