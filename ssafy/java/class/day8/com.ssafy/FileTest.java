package com.ssafy;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
		// Check c:\SSAFY Creation
		String dirName = "c:"+File.separator+"SSAFY"+File.separator+"mydir"; // File.separator로 OS에 독립적인 코딩이 가능.
		
		File file1 = new File(dirName); // 파일 객체가 만들어진 것. 파일이 생성된 것은 아님.

		if( file1.exists() ) {
			System.out.println("Folder Exists!" );
			
		}else {
			boolean success = file1.mkdir(); // 폴더 생성
			if( success ) {
				System.out.println("Folder Created!" );
			}
		}
		
		File file2 = new File(dirName, "test2.txt"); // 파일 생성
		
		//file2.createNewFile();
		file2.delete();
	}
}
