package com.ssafy.day6;

class Parent {
	int age;
	public void f(int a) {
		System.out.println("부모 f");
	}
}

class Child extends Parent {
	int age;
	@Override
	public void f(int a) { // 부모의 메소드 재정의
		System.out.println("자식 f 인자 하나");
	}
	public void f(int a, int b) { // 자식에 추가된 메소드, 같은 곳에 있는 메소드 오버로딩
		System.out.println("자식 f 인자 둘");
	}
	void pr() { // 자식에 추가된 메소드
		 System.out.println("자식 pr");
	}
}

public class OverridingTest {
//	오버라이딩 규칙
//	1. 메소드 이름이 같다. (변수 아님) 자바는 변수나 연산자의 다형성을 지원하지 않는다.
//	2. 서로 다른 클래스의 있는 메소드 (서로 다른 클래스는 반드시 상속 관계에 있다.)
//	3. 매개변수의 갯수와 타입이 같아야 한다. (반환되는 타입이 같다.)
//	4. 접근제한자는 부모보다 같거나 넓어야 한다. (private < default < protected < public)
	
	public OverridingTest() {
//		Parent p = new Parent();
//		p.f(1);
//		Child c = new Child();
//		c.f(1);
//		c.pr();
		
		Parent p1 = new Child();
		p1.f(1);
//		p1.f(1, 2); // 에러
//		p1.pr(); // 에러
	}

	public static void main(String[] args) {
		new OverridingTest();

	}

}
