package com.ssafy.singletone;

// 싱글톤 디자인 패턴을 적용
public class Teacher { // Instance는 되어야 한다.
//	3단계 : 멤버 변수의 자신의 객체를 접근하는 변수를 생성한다.
//	private static Teacher teacher = new Teacher();
	private static Teacher teacher;
	
	String name;
	String location;
	
//	1단계 : 외부 생성을 막는다.
	private Teacher() {
		System.out.println("선생 생성됨");
	}
	
//	2단계 : 외부에서 현재 객체를 얻어갈 수 있는 static 메소드를 만든다.
	public static Teacher getInstance() {
//		4단계 : 객체 생성 여부를 판단해서 만들어 져 있지 않으면 생성한다.
		// 학생이 전부 없어지면 JVM이 참조하지 않는 변수를 해제하기 때문에 선생 객체가 null이 됨.
		// 따라서 다음 학생이 들어왔을 때 선생 객체는 null임. 그래서 이 조건문이 필요.
		if (teacher == null) {  
			teacher = new Teacher();
		}
		return teacher;
	}
}
