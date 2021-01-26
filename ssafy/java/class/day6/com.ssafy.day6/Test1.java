package com.ssafy.day6;

class SA {
	void pr() { // 정의
		System.out.println("SA pr");
	}
}

class SB extends SA {
	
}

class SC extends SB {
	void pr() { // 재정의
		System.out.println("SC pr");
	}
}

class SD extends SC {

}

public class Test1 {

	public Test1() {
//		SA sa = new SC();
//		sa.pr();
		
//		SD sa = new SA(); // 에러
		
		SB sb = new SD();
		sb.pr();
	}
	
	public static void main(String[] args) {
		new Test1();
	}
}
