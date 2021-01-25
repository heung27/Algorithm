package com.ssafy.classSam;

public class ObjectTest {
	public static void main(String[] args) {
		// 휴대폰(Object = 사물)
//		명사 : 이름, 색상, 제조사, 가격
//		동사 : 켜다, 크다, 할부원금 + set, getter 메소드 + 생성자
		
		Phone phone = new Phone(); // 인스턴스화 과정
		Phone phone1 = new Phone(); // 인스턴스화 과정
		
		phone.name = "s";
		phone1.name = "s";
		
		System.out.println(phone == phone1);
	}
}

class Phone {
//	명사 : 이름, 색상, 제조사, 가격
	String name;
	String color;
	String maker;
	int price;
//	동사 : 켜다, 크다, 할부원금 + set, getter 메소드 + 생성자
	
}