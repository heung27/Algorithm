package com.ssafy.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest4 {

	public IOTest4() {
		File source = new File("IOTest1.java");
//		java com.ssafy.day9.IOTest2
		String desName = "IOTest3.java";
		
//		FileInput, FileOutput
//		JDK 7, Auto Closeable
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
				PrintWriter pw = new PrintWriter(new FileOutputStream(desName));) {
			String data = null; // 마지막 정보를 읽으면 null 반환
			while ((data = br.readLine()) != null) {
				pw.println(data);
			}
			pw.flush(); // 습관적 실행.
//			close 구문을 실행하면 자신이 내부 flush 메소드를 호출하고 닫기한다.
			System.out.println("파일 복사 성공");
		}catch(FileNotFoundException | NullPointerException e) {
			System.out.println("같은 처리 : " + e);
		}catch(IOException e) {
			System.out.println("입출력 오류 : " + e);
		}
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		new IOTest4();
	}
}
