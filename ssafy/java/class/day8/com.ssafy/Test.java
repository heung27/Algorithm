package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
	static void aaa(Object obj) {
		
	}
	// wrapper 클래스
	// 기본형을 객체화 시켜서 관리하는 클래스
	public static void main(String[] args) {
//		List와 Queue는 인터페이스, LinkedList는 클래스
		List<String> list11 = new LinkedList();
		Queue<String> list22 = new LinkedList();
		
		ArrayList<Character> list1 = new ArrayList<>();
		
		list1.add(new Character('A'));
		list1.add('B'); // auto box 발생
		
		int num = 10;
		// Auto Boxing 지원
		Integer inum = num;
//		Integer inum = new Integer(num);
		aaa(num); // auto box 발생
		aaa(inum);
		
		Integer aa = new Integer(10);
//		int a = aa.intValue(); // UnBoxing
		int a = aa; // Auto UnBoxing
		
//		ArrayList<int[]> list = new ArrayList<>();
//		list.add(new int[]{1,2,3,4});
		
//		ArrayList list = new ArrayList();
//		ArrayList<String> list = new ArrayList<>();
//		list.add("ssafy");
////		list.add(444);
////		list.add(true);
//		String sss = list.get(0);
////		int num = list.get(1);
//		
//		System.out.println("end");
	}
}
