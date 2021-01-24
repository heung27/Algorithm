package com.ssafy.test;

public class StaticMethodTest {
	
	int a = 10;
	public static void main(String[] args) {
		//static 메소드 앞에 쓰기
		
//		a =40; 에러. 해결 방법은 main에 static 제거 또는 a를 static으로 변경
		
//		SSData.aa(); 이 순간에 클래스가 로딩됨
		
		SSData sdata1 = new SSData();
		SSData sdata2 = new SSData();
		SSData sdata3 = new SSData();
		
		sdata1.num = 1;
		sdata2.num = 5;
		sdata3.num = 10;
		sdata1.bb(); // this가 인자로 들어간다고 생각 (메모리상에 메소드가 여러 개가 할당되는게 아님)
		sdata2.bb();
		sdata3.bb();
		SSData.aa(); // 스태틱 메소드 호출
		SSData.aa();
		SSData.aa();
	}
}

// static 메소드에서는 static 변수와 static 메소드만 접근할 수 있다.
// Instance 메소드는 Instance 메소드와 static 메소드 다 접근이 가능하다.

class SSData {
	public int num;
	static int su;
	
//	static은 class가 로딩되는 시점에 생성됨
	static void aa() { // static Method
//		num = 9; 불가. 아직 num이 만들어지지 않음 (인스턴스가 생성된 다음 접근 가능)
		su = 1; // 클래스 변수는 가능 
		ff();
//		bb(); 불가. 아직 bb가 만들어지지 않음 (인스턴스가 생성된 다음 접근 가능)
	}
	
	static void ff() {
		
	}
	
	void bb() { // Instance Method
		su = 1;
		num = 9;
		System.out.println(this.num);
	}
}
