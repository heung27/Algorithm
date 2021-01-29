package com.ssafy.day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest2 {

	public IOTest2() {
		File source = new File("IOTest1.java");
//		java com.ssafy.day9.IOTest2
		String desName = "IOTest3.java";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		FileInput, FileOutput
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(desName);
			
			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.flush(); // 습관적 실행.
//			close 구문을 실행하면 자신이 내부 flush 메소드를 호출하고 닫기한다.
			System.out.println("파일 복사 성공");
		}catch(FileNotFoundException e) {
			System.out.println("파일 오류 : " + e);
		}catch(IOException e) {
			System.out.println("입출력 오류 : " + e);
		}finally {
			try {
				if (fis != null) {
					fis.close();
				}
			}catch(IOException e) {
				
			}
			try {
				if (fis != null) {
					fis.close();
				}
			}catch(IOException e) {
				
			}
		}
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		new IOTest2();
	}
}
