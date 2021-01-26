package com.ssafy.day6;

public class InherTest {
	int a;
	public InherTest() {
		Student d1 = new Student();
//		Student d2 = new Student();
		Student d2 = getStudent(56789);
		
		d1.num = 56789;
//		d2.num = 56789;
		System.out.println(d1.num);
		System.out.println(d2.num);
		System.out.println(d1 == d2); // 해시 코드 값을 비교 false
//		System.out.println(d1.equals(d2)); // 해시 코드 값을 비교 false
		System.out.println(d1); // 해시 코드 출력
		System.out.println(d2); // 해시 코드 출력
		
		System.out.println(d1.equals(d2)); // 메소드 오버라이딩 사용. 두 객체의 번호를 비교.
//		a = 10;
//		System.out.println("end");
		
		Student ss = new Student();
		ss.num = 99;
		Object obj = new Student();
//		obj.num = 0; // 에러
		((Student)obj).num = 0; // 형변환 하면 가능
	}
	
	public Student getStudent(int num) {
		Student s = new Student();
		s.num = num;
		return s;
	}
	
	public static void main(String[] args) {
//		a = 10;
//		InherTest it = new InherTest();
		new InherTest(); // 이름이 없는 객체 생성
	}
}

class Student extends Object { // java.lang.Object
	int num;
	
	@Override
	public boolean equals(Object obj) { // 부모 변수는 자식의 추가된 변수를 접근할 수 없다.
//		return this.hashCode() == obj.hashCode(); // default equals 연산
		return this.num == ((Student)obj).num; // 형변환 하면 가능
	}
}