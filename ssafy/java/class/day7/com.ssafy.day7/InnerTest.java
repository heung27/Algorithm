package com.ssafy.day7;

class Other {
//	다른 클래스
}

// 클래스의 이름은 사용가능 문자, 영문 대소문자, 숫자, _, $(사용가능 하나 선언하지는 않는 것이 추천)

public class InnerTest {
	int a = 10;
	static int num = 10;
	class MemberInnerClass { // 클래스 파일명이 아우터 클래스 이름$클래스 이름으로 만들어짐
		void pr() {
			System.out.println("MemberInnerClass");
		}
	}
	static class StaticMemberInnerClass { // 클래스 파일명이 아우터 클래스 이름$클래스 이름으로 만들어짐
		void pr1() {
			System.out.println("StaticMemberInnerClass");
		}
	}
	public InnerTest() {
		a = 88;
		MemberInnerClass a = new MemberInnerClass();
	}
	public static void main(String[] args) {
//		a = 10;
//		new InnerTest();
		InnerTest itt = new InnerTest();
		itt.a = 10;
		MemberInnerClass it = itt.new MemberInnerClass();
		it.pr();
		num = 999;
		
		StaticMemberInnerClass sss = new StaticMemberInnerClass();
		sss.pr1();
	}
}
