package com.ssafy.test;

public class StaticTest2 {
	public static void main(String[] args) {
		DataSam ds1 = new DataSam();
		DataSam ds2 = new DataSam();
		DataSam ds3 = new DataSam();
		
		ds1.a = 10;
		ds2.a = 20;
		ds3.a = 30;
//		Instance 변수
//		ds3이 ds1의 a를 변화시키는 방법은 없다. 
		
		ds1.b = 100;
		ds2.b = 200;
		ds3.b = 300;
//		static 변수
//		ds3이 ds1의 b를 변화시키는 방법은 있다.(공유) (side effect : 부작용)
//		side effect는 객체 지향에서 좋은게 아님.
//		객체지향은 서로의 객체가 영향을 미치는 것을 최소화 한다.
//		알고리즘 메모리 최적화 (로직적 관리)
	}
}

class DataSam {
	int a;
	static int b;
}