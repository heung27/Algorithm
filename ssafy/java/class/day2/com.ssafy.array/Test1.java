package com.ssafy.array;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		// 기본형, 참조형
		// call by value, call by reference
		
		int a = 10;
		f1(a);
		System.out.println("main a :" + a);
		
//		int[] arr, num; // 둘 다 int 배열
//		int arr[], num; // arr은 int배열, num은 int
		
		int[] arr = new int[]{1, 2, 3, 4, 5};
		f2(arr);
		System.out.println("main : " + Arrays.toString(arr));
		
//		alt + shift + r; 같은 문자열 변경
		String name = "ssafy"; // 참조형 String 불변의 원칙
		f3(name);
		System.out.println("name : " + name);
	}
	private static void f3(String name) {
		// TODO Auto-generated method stub
		System.out.println("f3 name : " + name);
	}
	static void f2(int[] brr) {
		brr[2] = 200;
		System.out.println("f2 : " + Arrays.toString(brr));
	}
	static void f1(int a) {
		a = 20;
		System.out.println("f1 a :" + a);
	}
}
