package com.ssafy.classSam;

public class GCTest {
	public static void main(String[] args) {
		Sam1 s1;
		s1 = new Sam1();
		Sam1 s2 = new Sam1();
		s1.f();
		s2 = null;
		System.gc(); // 이제 gc해라고 했으니 VM(JVM)이 알고 있다가 유휴시간에 동작하도록 함
		s1 = null;
		System.gc();
		
		System.out.println("end");
		
		String s = "S";
		s = ((s + "a") + 3) + true + 3.4 + new String("ss");
		new StringBuilder(new StringBuilder(s).append("a").toString()).append(3).toString();
		
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.append("a");
		sb.append(3);
		sb.append(true);
		sb.append(3.4);
		sb.append(new String("ss"));
		
		//체인 메소드 기법
		sb.append(s).append("a").append(true).append(3.4).append(new String("ss"));
	}
}

class Sam1 {
	void f () {
		
		return;
	}
}