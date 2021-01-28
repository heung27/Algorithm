package com.ssafy;

public class ExceptionTest3 {

	public static void main(String[] args) {
		
		ControllerRunEx ec = new ControllerRunEx();
		//ec.m1();

		try {
			ec.m1();
		}catch(NullPointerException e) { // 문법적으로는 가능한데, 쓰지 않아야 함.
			;;
		}
	}

}

class ControllerRunEx {
	public void m1() { // throws NullPointerException 빼더라도 컴파일 에러 x. 실행되면서 에러가 남.
		String s = null;
		s.length();		
	}
}