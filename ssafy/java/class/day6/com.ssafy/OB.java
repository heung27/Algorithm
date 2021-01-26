package com.ssafy;

public class OB extends OA {
	@Override
	void m1() { System.out.println("OB m1()");}
	
	void m2() { System.out.println("OB m2()");} // 이렇게 되면 에러가 발생하지 않음. 오버라이딩된게 아니라 새로운 메소드를 정의한 것.
}
