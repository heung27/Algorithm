package com.ssafy.io;

import java.util.Scanner;

public class IO3_ScannerTest {
	public static void main(String[] args) {
//		5\n
		Scanner sc = new Scanner(System.in);
		System.out.println("기수 : "+sc.nextInt()); // 구분자를 남겨 놓음.
//		System.out.println("이름 : "+sc.next());
		sc.nextLine();
		System.out.println("이름 : "+sc.nextLine());
	}
}
