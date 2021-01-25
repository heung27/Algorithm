package com.ssafy.test;

public class StaticTest { // Outer
	public static void main(String[] args) {
//		static(정적) 키워드 다이나믹(동적)
//		1. 클래스 (Inner, nested) 앞에 선언
//		2. 메소드 앞에 선언
//		3. 멤버변수 앞에 선언
		
//		StaticTest.S s;
		
		SData s1 = new SData();
		SData s2 = new SData();
		SData s3 = new SData();
		s1.a++;
		s1.b++;
		s2.a++;
		s2.b++;
		s3.a++;
		s3.b++;
		
		System.out.println("s1.a : " + s1.a + ", b : " + s1.b);
		System.out.println("s2.a : " + s2.a + ", b : " + s2.b);
		System.out.println("s3.a : " + s3.a + ", b : " + s3.b);
	}
	
//	static class S { // 클래스(Inner, nested)
//		
//	}
}

class SData {
	static int a; // static 영역에 생성
	int b;
}