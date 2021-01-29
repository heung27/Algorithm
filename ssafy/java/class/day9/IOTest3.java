package com.ssafy.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest3 {

	public IOTest3() {
		File source = new File("IOTest1.java");
//		java com.ssafy.day9.IOTest2
		String desName = "IOTest3.java";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		필터 사용 BufferedReader == (PrintWriter) * BufferedWriter
		BufferedReader br = null;
		InputStreamReader reader = null;
		PrintWriter pw = null;
//		FileInput, FileOutput
		try {
			fis = new FileInputStream(source);
//			필터 생성자는 (노드 생성자 아님) 반드시 생성자에 다른 필터 또는 노드를 가리켜야 한다.
			reader = new InputStreamReader(fis); // 얘는 인자로 Stream 가능. Byte => Character
			br = new BufferedReader(reader);
			fos = new FileOutputStream(desName);
			pw = new PrintWriter(fos); // 출력. 얘는 인자로 둘 다 가능. // crlf (개행문자?)

			String data = null; // 마지막 정보를 읽으면 null 반환
			while ((data = br.readLine()) != null) {
				pw.println(data);
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
			try {
				if (br != null) {
					br.close();
				}
			}catch(IOException e) {
				
			}
			try {
				if (reader != null) {
					reader.close();
				}
			}catch(IOException e) {
				
			}
		}
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		new IOTest3();
	}
}
