 package com.ssafy.test;

// javac -d . StaticTest2.java
public class StaticTest3 {
	public static void main(String[] args) {
		aa();
//		InnerClass ic = new InnerClass(); 에러 - 스태틱 블록안에서는 불가
	
		int[] arr = new int[3];
//		arr[1] = 0;
		System.out.println(arr[0]);
	}
	static void aa() {
		
	}
	class InnerClass { // static으로 만들어 주어야 함
		
	}
}