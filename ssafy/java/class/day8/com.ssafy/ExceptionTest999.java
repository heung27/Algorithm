package com.ssafy;

import java.io.FileInputStream;
import java.util.Scanner;

public class ExceptionTest999 {
	public ExceptionTest999() {
		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
		
		String sNum = sc.next();
//		숫자 모양의 정수 문자열을 실제 정수로 변환하는 기능
//		Integer.parseInt("123");
		
		// String이 들어오면 throws NumberFormatException (RuntimeException - unChecked Exception 계열) 처리 안해줘도 실행은 됨.
		int num = 0;
		try { // 그래도 처리 해줘야 좋은 소스.
			num = Integer.parseInt(sNum);
		}catch(NumberFormatException e) {
			num = 999999;
		}
		
		System.out.println(num+99);
		System.out.println("end");
		
		// throws FileNotFoundException (Checked Exception 계열) 예외 처리가 필요.
//		FileInputStream is = new FileInputStream("a.txt"); 
	}
	
	public static void main(String[] args) {
		new ExceptionTest999();
	}
}
