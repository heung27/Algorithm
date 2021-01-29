package com.ssafy.day9;

public class ConstBooleanTest {
	static final boolean D = true;
	public ConstBooleanTest() {
		// static boolean 상수 일 때.
		// if 문이 오로지 true이면 컴파일러가 if를 생략하고 실행, false이면 컴파일러가 if문을 없애버리고 실행.
		if (D) {
			System.out.println("디버깅용"); // 업무시 출력
		}
		else {
			System.out.println("디버깅용1");
		}
		System.out.println("업무용");
		if (D) {
			System.out.println("디버깅용");
		}
	}

	public static void main(String[] args) {
		new ConstBooleanTest();
	}
}
