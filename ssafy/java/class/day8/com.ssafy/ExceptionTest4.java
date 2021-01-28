package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest4 {

	public static void main(String[] args) {
		
		// Not Runtime Exception
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt");		
		}catch(FileNotFoundException e) {
			System.out.println("Handing Exception : " + e.getMessage());
		}catch(IOException e) {
			System.out.println("Handing Exception : " + e.getMessage());
		}catch(Exception e) { // 순서 주의
			System.out.println("Handing Exception : " + e.getMessage());
		}
		
		// Runtime Exception
//		try {
//			String s = null;
//			s.length();
//		}catch(RuntimeException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//		}catch(NullPointerException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//		}
	}

}