package com.ssafy.day7;

public class InnerTest2 {
//	local Inner class (Inner, nested class)
	void ppp() {
		aa();
	}
	void aa() {
//		자바 소스는 선언과 호출에 라인 우선순위 무시
//		단, Inner 클래스는 선언하고 생성해서 사용해야 한다.
//		ATest11 a = new ATest11(); // 에러
		class ATest11 {
			void pr() {}
		}
		ATest11 a = new ATest11(); 
		a.pr();
	}
	public InnerTest2() {
		
	}
	public static void main(String[] args) {
		
	}
}
