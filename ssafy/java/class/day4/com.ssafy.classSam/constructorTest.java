package com.ssafy.classSam;

public class constructorTest {
	public static void main(String[] args) {
//		java.lang.* 구믄을 컴파일러가 자동 주입한다.
		System.out.println("");
		Data d1 = new Data(); // 생성자를 통해 인스턴스 과정을 사용해서 인스턴스 객체가 만들어진다.
		Data d2 = new Data("ssafy");
		Data d3 = new Data("ssafy", 25);
		
		d2.setName("java");
		d2.name = "월말평가";
		System.out.println(d2.getName());
		System.out.println(d2.name);
		
		Data d4;
		d4 = new Data();
		
		Sam sam = new Sam();
		sam.name = "ssafy";
//		sam.age = -30;
		sam.setAge(30);
//		System.out.println(sam.age);
		System.out.println(sam.getAge());
		
		String s1 = "sss";
		String s = "sss";
		System.out.println(s == s1);
		
	}
}

class Sam {
	String name; // 필드, 변수(멤버)
	private int age;
	public void setAge(int age) {
		if (age < 0) {
			return;
		}
		this.age = age;
	}
	public int getAge() {
		return age;
	}
}

class Data {
//	기본 생성자가 컴파일러에 의해서 자동 주입된다.
	
	String name; // 멤버 변수(필드), 속성(Property) => 지원하지 않음
	int age;
	
	Data() { // 특수 메소드, 반환타입이 없고, 클래스 이름과 철자가 같은 메소드. 사용할 경우 new 키워드 다음에 사용
		System.out.println("생성자");
	}
	
	Data(String name) {
		System.out.println("셍성자");
		this.name = name;
	}
	
	Data(String name, int age) {
		// 지역(Local) 변수
		System.out.println("셍성자");
		this.name = name;
		this.age = age;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
}