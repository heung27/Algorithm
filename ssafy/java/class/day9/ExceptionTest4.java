package com.ssafy.day9;

import java.util.ArrayList;

class Student {
	String name;
	int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}

// 나이 범위 체크 오류
//class AgeIndexOutOfBoundException extends Exception { // 꼭 Exception가 아니여도 됨. Checked Exception
//	String title;
//	AgeIndexOutOfBoundException(String title) {
//		this.title = title;
//	}
//	String getTitle() {
//		return title;
//	}
//}

class AgeIndexOutOfBoundException extends Exception {
	AgeIndexOutOfBoundException(String message) {
		super(message);
	}
}

// 메소드 재정의시 Exception은 부모보다 자식 개념이 되어야 한다.
class MySuper {
	void pr() throws AgeIndexOutOfBoundException { // throws IndexOutOfBoundException 가능.
		
	}
	void aa() {}
}

class MySub extends MySuper {
	protected void pr() throws AgeIndexOutOfBoundException { // throws Exception 뷸가능. 오류.
		
	}
	void aa() {}
}

public class ExceptionTest4 {
	ArrayList<Student> list = new ArrayList<>();
	public ExceptionTest4() {
		Student student = new Student("홍길동", 33);
		try {
		addStudent(student);
		}catch (AgeIndexOutOfBoundException e) {
//			System.out.println("뭐가 문제 있나1 : "+e.title);
		}
		student = new Student("이싸피", -33);
		try {
			addStudent(student);
		}catch (AgeIndexOutOfBoundException e) { // 오류나면 catch안에서 해결.
//			System.out.println("뭐가 문제 있나2 : "+e.title);
			System.out.println("뭐가 문제 있나2 : "+e.getMessage());
		}
		
		for (Student s : list) {
			System.out.println(s);
		}
	}
	
	void addStudent(Student student) throws AgeIndexOutOfBoundException { // 여러 개 던질 수 있음.
		if (student.age < 1 || student.age > 100) {
//			System.out.println("나이가 문제가 있음");
			// 반드시 Exception을 상속 받아야 throw 가능.
			throw new AgeIndexOutOfBoundException("나이 오류 : " + student.age); // err. throws or try catch 해야함. unChecked Exception 일때는 컴파일 에러 x.
		}
		else {
			list.add(student);
		}
	}
	
	public static void main(String[] args) { // main에서 throws AgeIndexOutOfBoundException 하면 JVM이 처리
		new ExceptionTest4();
	}
}
