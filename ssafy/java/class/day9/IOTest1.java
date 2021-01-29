package com.ssafy.day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest1 {
	/* Stream : 입출력 흐름 Stream
	 * Input 전용, Output 전용.	예외) RandomAccessFile : 겸용
	 * I/O 중심은 Java
	 * 
	 * Node : (키보드,모니터)==표준IO, 파일IO, 네트워크IO
	 * Filter : 버퍼, Data, byte=>character, 객체 출력
	 * 
	 * Byte 단위 입출력 (이미지, 사운드, 영상) ~~~~~Stream
	 * Character 단위 입출력 (파일) ~~~~Reader, ~~~~~Writer
	 * 
	 * ex1) DataInputStream : 입력용, byte, Filter
	 * ex2) FileWriter : 출력용, character, Node
	 * 
	 * IO를 대표하는 추상클래스
	 * InputStream, OutputStream
	 * Reader, Writer
	 * 
	 * 파일 및 디렉토리(폴더)를 관리하는 클래스 : File
	 */
	public IOTest1() {
//		현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java 파일로 복사
		File source = null;
		source = new File("."); // . 현재 경로, .. 상위 경로
		System.out.println(source.isDirectory());
		System.out.println(source.getName());
		System.out.println(source.getAbsolutePath());
		
		System.out.println("********************");
		source = new File(source, "IOTest1.java");
		System.out.println(source.isDirectory());
		System.out.println(source.getName());
		System.out.println(source.getAbsolutePath());
		
		System.out.println("존재여부 : "+source.exists());
		System.out.println(source.length()+"byte");
//		System.out.println(source.delete());
		
//		이름 변경
//		File newName = new File(".","new.text");
//		source.renameTo(newName);
		
//		현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java 파일로 복사
//		window : \		unix : /
		String desName = "C:"+File.separator+"IOTest1.java";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		FileInput, FileOutput
		try {
//			open 하면 할상 close한다.
//			file은 open이 없고 생성이 open을 대신한다.
			fis = new FileInputStream(source);
			fos = new FileOutputStream(desName);
			
//			ABCDF
//			000A
			int data = fis.read(); // 1byte를 읽어오는 메소드
//			BCDF
//			000B
			data = fis.read();
//			10101010 10101010 11111111 11110000 이렇게 4바이트 있으면
//			00000000 00000000 00000000 10101010 <= 이게 리턴
//			00000000 00000000 00000000 10101010
//			00000000 00000000 00000000 11111111
//			00000000 00000000 00000000 11110000
//			11111111 11111111 11111111 11111111 <= 읽은 데이터가 없음 return -1
			fos.write(data);
//			00000000 00000000 00000000 10101010 <= 이게 write
//			자바의 기본적인 연산(처리) int
			

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
		new IOTest1();
	}
}
