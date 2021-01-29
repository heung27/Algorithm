package com.ssafy.day9;

public class ExceptionTest3 {
	public ExceptionTest3() {
		System.out.println("생성자 시작");
		aa();
		System.out.println("생성자 끝");
	}
	void aa() {
		System.out.println("aa 시작");
		try {
			bb();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("aaa : "+e.getMessage());
		}
		System.out.println("aa 끝");
	}
	void bb() { // throws ArrayIndexOutOfBoundsException이 생략
		System.out.println("bb 시작");
		System.out.println("bb 실행");
		int idx = 10;
		int[] arr = {1,3,5};
		if (idx < 3) {
			System.out.println(arr[idx]);
		}
		else {
			System.out.println("범위 오류");
			throw new ArrayIndexOutOfBoundsException("내가 보낸 문자");
		}
		System.out.println("bb 끝");
	}
	public static void main(String[] args) {
		new ExceptionTest3();
	}
}
