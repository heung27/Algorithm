package com.ssafy.day6;

// 우리 업무에서 삼각형, 사각형, 원을 관리하자. ==> 도형 (실제 없는 => 추상화)
abstract class Shape {
	int x, y;
	
//	메소드 추상화
	abstract void print();
}

class Rect extends Shape {
//	하나의 정점과 width, height로 관리
//	int x, y;
	int width, height;
	void print() {
		System.out.println("사각형 출력");
	}
}

class Tri extends Shape {
//	세 정점으로 관리
//	int x, y;
	int x1, y1;
	int x2, y2;
	void print() {
		System.out.println("삼각형 출력");
	}
}

class Circle extends Shape {
//	하나의 정점과 반지름으로 관리
//	int x, y;
	int radius;
	void print() {
		System.out.println("원 출력");
	}
}

public class AbstractTest {

	public AbstractTest() {
		Rect rect = new Rect();
		Tri tri = new Tri();
		Circle circle = new Circle();
		
		circle.radius = 99;
		rect.width = 100;
		tri.x2 = 5;
		tri.y2 = 4;
		
//		각각의 도형을 전달해서 확인하는 메소드를 만들어라. (상속의 필요성)
		print(rect);
		print(tri);
		print(circle);
		
//		부모 변수 = new 자식();
		Shape shape = new Rect();
//		Shape shape = new Shape(); // 추상 클래스로 설정하여 생성되지 못 함.
//		Shape shape = null; // 이건 가능
	}
	
	void print(Shape shape) {
//		shape.printRect(); // 부모 래퍼런스는 자식에 추가된 메소드 접근 불가
		shape.print(); // 부모 클래스에 함수를 정의하여 재정의를 통해 해결
		
//		원이 들어오면 원의 반지름을 출력
//		System.out.println(shape.radius); // err
		
		if (shape instanceof Rect) {
//			사각형의 너비를 출력하라
			Rect rect = (Rect)shape; // 상속관계가 있으면 자식으로 형변환 가능
			System.out.println(rect.width);
		}
		else if (shape instanceof Circle) {
			Circle circle = (Circle)shape;
			System.out.println(circle.radius);
		}
		else if (shape instanceof Tri) {
			Tri tri = (Tri)shape;
			System.out.println(tri.x2 + "," + tri.y2);
		}
	}
	
//	void print(Rect rect) {
//		System.out.println("사각형 확인");
//	}
//	
//	void print(Tri tri) {
//		System.out.println("삼각형 확인");
//	}
//	
//	void print(Circle circle) {
//		System.out.println("원 확인");
//	}

	public static void main(String[] args) {
		new AbstractTest();
	}
}
