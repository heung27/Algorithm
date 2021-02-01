package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest {
	public static void main(String[] args) {
		// 안과 녕 사이에 " \n"은 무시됨. 구분자를 만나면 그 직전까지 읽어들임.
		String s1 = "안 \n녕\n";
		Scanner sc = new Scanner(s1);
		System.out.print("읽은 문자열 : "+sc.next());
		System.out.print(",읽은 문자열 : "+sc.next());
		System.out.print("\n===========================\n");
		
		// 개행 문자를 빼고 받음. 구분자를 만나면 구분자를 빼고 읽어들임.
		String s2 = "안 녕\n";
		Scanner sc2 = new Scanner(s2);
		System.out.print("읽은 문자열 : "+sc2.nextLine());
		System.out.print("\n===========================\n");
		
		String s3 = "안 \n    녕\n";
		Scanner sc3 = new Scanner(s3);
		System.out.print("읽은 문자열 : "+sc3.nextLine());
		System.out.print(",읽은 문자열 : "+sc3.nextLine());
	}
}
