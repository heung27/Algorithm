package com.ssafy;

public abstract class AbstractFolder {
	public abstract void fold();
	public abstract void open();
	
	public void powerOn() {
		System.out.println("Power On!");
	}
}
 

interface ManyIF{
	// interface안에 method는 access modifier를 생략하면 public이 됩니다. (default x)
	void m1();
	void m2();
	void m3();
	void m4();
	void m5();
}

//class MyClass implements ManyIF{
//
//	@Override
//	public void m1() {}
//
//	@Override
//	public void m2() {}
//
//	@Override
//	public void m3() {}
//
//	@Override
//	public void m4() {}
//
//	@Override
//	public void m5() {}
//	
//}

abstract class ManyIFAdapter implements ManyIF{
	// access modifier visibility를 줄일 수 없음.
	public void m1() {}; // public을 줄이면 에러
	public abstract void m2();
	public void m3() {};
	public void m4() {};
	public abstract void m5();
}

class MyClass extends ManyIFAdapter{

	@Override
	public void m2() {}

	@Override
	public void m5() {}
	
}