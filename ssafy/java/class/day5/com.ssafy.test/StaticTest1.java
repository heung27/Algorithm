package com.ssafy.test;

public class StaticTest1 {
	public static void main(String[] args) {
		Data1 data1; 
//		data1 = new Data1(); // 클래스 로딩 + 객체 생성
//		data1 = new Data1(1);
//		data1 = new Data1();
		
		Data1.print(); // 클래스 로딩
		Data1.print();
		Data1.print();
	}
}

class Data1 {
	int num1 = 10;
	static int num2 = 20;
	static void print() {
		System.out.println("print");
	}
	
	static { // 클래스가 메모리에 로딩되면 한번만 실행되는 블럭 : Static block
		System.out.println("클래스 로딩");
		int a; // 이 지역 안에서만 사용되는 변수 (지역변수) static 변수가 되는게 아님.
	}
	
	{ // 어떠한 인스턴스이든지 무조건 실행 이름 : Instance block
		System.out.println("같은 내용");
	}
	
	Data1() {
//		System.out.println("같은 내용"); // 어떠한 인스턴스이든지 무조건 실행
		System.out.println("생성자1111 : " + num1 + ", num2 : " + num2);
	}
	Data1(int num1) {
//		System.out.println("같은 내용"); // 어떠한 인스턴스이든지 무조건 실행
		this.num1 = num1;
		System.out.println("생성자2222 : " + num1 + ", num2 : " + num2);
	}
}
