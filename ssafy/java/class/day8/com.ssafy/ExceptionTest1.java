package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest1 {
	public static void main(String[] args) {  // #3 throws IOException
		
		// Code We Need
//		FileInputStream fins = new FileInputStream("hello.txt");
		
		// #1 try-catch-finally
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("hello.txt");			
//		}catch(FileNotFoundException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//			e.printStackTrace();
//		}finally {
//			try {
//				fis.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		// #2 throws
//		 public static void main(String[] args) throws FileNotFoundException { // main 메소드에서 예외가 발생하면 JVM으로 throw
//		 FileInputStream fins = new FileInputStream("hello.txt");
		
		// #3 throw e
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("hello.txt");			
//		}catch(FileNotFoundException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//			e.printStackTrace();
//			
//			throw new IOException(); // throw IOException 객체 to main()
//			
//		}finally {
//			try {
//				fis.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		// #4 use AutoCloseable
		try( FileInputStream fis  = new FileInputStream("hello.txt"); ) { // AutoCloseable
			// fis code
		}catch(IOException e) {
			System.out.println("Handing Exception : " + e.getMessage());
			e.printStackTrace();
		}	

	}
}
