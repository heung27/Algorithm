package com.ssafy.day9;

public class ExceptionTest1 {
	public ExceptionTest1() {
		System.out.println("start 생성자");
		int[] arr = {4, 3, 7, 5, 1};
		int idx = 5;
		
//		try 블럭은 전체 속도를 무지 느리게 만든다.
//		try 블럭은 꼭 필요한 영역만 블럭 사용
//		try 블럭은 변수의 효력에도 영향을 미친다.
//		String s;
		String s = null; // 초기화 필요 !
		try {
			s = "ssafy";
			int num = 10;
			System.out.println("1");
			System.out.println(arr[idx]);
			// 오류가 발생하면 그 이후 라인은 실행되지 않는다. (블럭 안)
			System.out.println("2");
//			System.out.println("파일을 닫았습니다."); 오류 나면 실행 x
		}catch(ArrayIndexOutOfBoundsException e) {
			// catch 되었으면 실행됨
			System.out.println("3");
//			System.out.println(s); // err. 초기화 필요.  컴파일러가 try 블럭을 빼고 컴파일 한다.
//			System.out.println(num); // err. try 블럭과 catch 블럭은 별개
//			System.out.println(e);
//			System.out.println("파일을 닫았습니다."); 오류가 나지 않으면 실행 x
		}finally {
			System.out.println("파일을 닫았습니다."); // 오류가 발행하든 하지않든 실행
		} // try ~ finally 문법적인 에러는 없지만 쓸 필요가 없음.
		
		// 아무 상관없이 실행됨
		System.out.println("4");
//		if (idx < arr.length) {
//			System.out.println(arr[idx]); // ArrayIndexOutOfBoundsException (Runtime Exception)
//		}
		System.out.println("end 생성자");
	}
	public static void main(String[] args) {
		System.out.println("start main");
		new ExceptionTest1();
		System.out.println("end main");
	}
}
