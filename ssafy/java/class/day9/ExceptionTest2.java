package com.ssafy.day9;

public class ExceptionTest2 {
	public ExceptionTest2() {
		int[] arr = {1,2,3};
		String name = null;
		
//		Exception : 새우 그물 => 부하를 많이 건다.
//		ArrayIndexOutOfBoundsException : 고래 그물 => 부하를 적게 건다.
		try {
			System.out.println(name.length());
			System.out.println(arr[5]); // NullPointerException
//			ArrayIndexOutOfBoundsException와 NullPointerException는 상속관계가 아니기 때문에 순서 상관 x
//			상속 관계가 존재하는 catch는 반드시 자식부터 catch하여야 한다.
//			ArrayIndexOutOfBoundsException와 RuntimeException는 상속관계이기 때문에 순서를 바꾸면 에러
		}catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println("배열 첨자 오류 " + e);
			System.out.println("배열 첨자 오류 " + e.toString());
			System.out.println("배열 첨자 오류 " + e.getMessage());
		}catch (RuntimeException e) { // 부모로 캐치가 가능. NullPointerException -> RuntimeException
			System.out.println("오류 "+e.getMessage());
		}
//		}catch (NullPointerException | ArrayIndexOutOfBoundsException e) { // 부모 Exception으로 변경. RuntimeException
//			
//		}
		System.out.println("end");
	}
	public static void main(String[] args) {
		new ExceptionTest2();
	}
}
