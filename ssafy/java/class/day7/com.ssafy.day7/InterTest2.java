package com.ssafy.day7;

// 게임 프로그램

interface GameInfo {
	void attack();
	default void print() { // 인터페이스에서 바디를 구현할 때 default, 접근제한자 default랑 다름. 이것도 public 생략된 것.
		System.out.println("최대점수");
	}
	static void pr() {
		System.out.println("스태틱");
	}
}

class A implements GameInfo {
//	공격
	public void attack() {
		System.out.println("A 개발자의 공격");
	}
}

class SuperB {
	
}

class B extends SuperB implements GameInfo {
//	공격
	void fire() {
		System.out.println("B 개발자의 공격");
	}
	public void attack() {
		fire();
	}
	public void print() {
		System.out.println("재정의 최대점수");
	}
}

class C implements GameInfo {
	void push() {
		System.out.println("C 개발자의 공격");
	}
	public void attack() {
		push();
	}
}

public class InterTest2 {
	public InterTest2() {
//		GameInfo.print(); 스태틱이 아니라서 에러
		GameInfo.pr();
		GameInfo a = new A();
		a.print();
		A aa = new A();
		GameInfo b = new B();
		b.print();
		GameInfo c = new C();
		attack(a);
		attack(b);
		attack(c);
	}
	
	void attack(GameInfo player) {
		player.attack();
	}
	
	public static void main(String[] args) {
		new InterTest2();
	}
}
