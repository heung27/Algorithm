package com.ssafy.day7;

// Fianl 키워드 예제
// 1. 클래스 앞에 사용하면 더이상 상속이 되지 않습니다.
// 2. 메소드 앞에 사용하면 더이상 재정의 되지 않습니다.
// 3. 변수 앞에 사용하면 상수로 선언된다.


//final class SSA { // 상속을 허용하고 싶지 않다.
//	void aa() {
//		System.out.println("변경되면 안되는 메소드");
//	}
//}

//class SSA { 
//	final void aa() { // 상속을 허용하고 싶지 않다.
//		System.out.println("변경되면 안되는 메소드");
//	}
//}

class SSA { 
	void aa() {
		System.out.println("변경되면 안되는 메소드");
	}
}

class SubSSA extends SSA {
	void aa() {
		System.out.println("내 맘대로 변경");
	}
}

//class MyMath extends Math { // 에러. Math라는 클래스는 final로 정의되어 있음.
//	public int max(int a, int b) {
////		나만의 구현
//		return 1;
//	}
//}

public class FinalTest {
	public FinalTest() {
		SSA ssa = new SSA();
//		int max = Math.max(3, 5);
		pr(ssa);
	}
	
	void pr(SSA ssa) {
		ssa.aa();
	}
	public static void main(String[] args) {
		new FinalTest();
	}
}
