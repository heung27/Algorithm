package com.ssafy.day7;

//abstract class Sam1 {
interface Sam1 {
//	인터페이스 안에 있는 모든 변수와 메소드의 접근 제한자는 public만 허용한다.
	int MAX = 100; // static final 생략
//	int MIN; // 에러, final이 되므로 초기화가 필요.
//	abstract void f1();
//	abstract void f2();
	void f1(); // public abstract 생략
	public abstract void f2(); // 실제 사용하려면 반드시 구현(상속)해야만 한다.
}

interface Sam99 {
	void f99(); // public abstract 생략
}

// 인터페이스의 상속
interface inter1 {
	void aa();
}

interface inter2 {
	void bb();
}

interface inter3 {
	void cc();
}

interface SubInter extends inter1, inter2, inter3 { // 인터페이스의 상속. 다중 상속이 가능.
	void dd();
}

class Work implements SubInter {
	@Override
	public void cc() {
		
	}

	@Override
	public void bb() {
		
	}

	@Override
	public void aa() {
		
	}

	@Override
	public void dd() {
		
	}
}

class Parent { // 생성도 되고, 독자적인 일반적인 변수와 기능 구현된 메소드를 가짐
	void f3() { 
		System.out.println("dfdf");
	}
}

class SubSam1 extends Parent implements Sam1, Sam99 { // 다중 구현
	public void f1() { // 접근제한자 에러 주의 public
		System.out.println("bb");
//		MAX = 50;
	}
	public void f2() {
		System.out.println("aaaaa");
	}
	public void f3() { // Parent 클래스의 메소드 재정의

	}
	@Override
	public void f99() { // 추상 클래스로 만들어버리면 구현하지 않아도 됨
		
	}
}

class SubSam2 extends Parent implements Sam1 {
	public void f1() {
		System.out.println("bb");
//		MAX = 90;
	}
	public void f2() {
		System.out.println("aaaaa");
	}
}

public class InterTest {
	public InterTest() {
		SubSam1 subsam1 = new SubSam1();
		subsam1.f1();
		subsam1.f2();
		subsam1.f3();
		subsam1.f99();
	}
	public static void main(String[] args) {
		
	}
}
