package com.ssafy.day7;

interface MouseListner {
	void click();
	void dbClick();
	void pressed();
	void released();
	void mouseOver();
	default void mouseOut() {};
}

abstract class MouseAdapter implements MouseListner {
	@Override
	public void click() {}

	@Override
	public void dbClick() {}

	@Override
	public void pressed() {}

	@Override
	public void released() {}

	@Override
	public void mouseOver() {}

//	@Override
//	public void mouseOut() {}
}

class MyMouseAction extends MouseAdapter {
	// click에 대해 동작 구현
	@Override
	public void click() {
		System.out.println("나의 액션 자바");
	}
//	@Override
//	public void click() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void dbClick() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void pressed() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void released() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseOver() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseOut() {
//		// TODO Auto-generated method stub
//		
//	}
}

public class InterTest3 {
	public InterTest3() {
		int[] arr = new int[3];
		System.out.println(arr instanceof int[]);
	}
	public static void main(String[] args) {
		new InterTest3();
	}
}
