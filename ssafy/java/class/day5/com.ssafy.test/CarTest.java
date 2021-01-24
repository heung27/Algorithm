package com.ssafy.test;

public class CarTest {
	public static void main(String[] args) {
		Car car1; // 클래스가 메모리에 로딩. static 변수도 같이
		car1 = new Car(); // 멤버 변수 메모리 할당.
		
		Car car2 = new Car();
		Car car3 = new Car();
		
//		car1.serialNumber = 1;
//		car2.serialNumber = 2;
//		car3.serialNumber = 3;
//		car1.setSerialNumber(3);
		System.out.println(car1.getSerialNumber());
		System.out.println(car2.getSerialNumber());
		System.out.println(car3.getSerialNumber());
		
		Car carTemp = new Car();
		System.out.println(carTemp.getSerialNumber());
		
		System.out.println(car1.num); // static 변수 == class 변수
		System.out.println(car2.num);
		System.out.println(car3.num);
	}
}
//tip. 라인 삭제 : ctrl + d, 소스 자동 생성 : alt + shift + s, 같은 이름 한꺼번에 교체 : shift + alt + r
class Car {
	static int num = 0; // 클래스 변수 (멤버 변수) 공유(Share)
	private int serialNumber; // 인스턴스 변수 (멤버 변수)
	
	public Car() {
		// 스태틱 변수 이렇게 이용
		num++; 
		serialNumber = num;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
}