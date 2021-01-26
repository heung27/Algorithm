package com.ssafy;

public class OverridingABCDE {
	public static void main(String[] args) {
		//AA x = new CC(); x.a(); 에러
		CC x1 = new EE(); x1.b(3); // CC: b(int i)
		//DD x = new BB(); x.b(); 타입 에러
		BB x2 = new DD(); x2.a(3); // DD: a(int i)
	}
}

class AA{
	void a(int i) { System.out.println("AA:a(int i)"); }
}

class BB extends AA{
	void b() { System.out.println("BB:b()"); }
}

class CC extends BB{
	void a() { System.out.println("CC:a()"); }
	void b(int i) { System.out.println("CC:b(int i)"); }
}

class DD extends CC{
	void a(int i) { System.out.println("DD:a(int i)"); }
	void b() { System.out.println("DD:b()");}
}

class EE extends DD{
	void a() { System.out.println("EE:a()"); }
	void b() { System.out.println("EE:b()"); }
}