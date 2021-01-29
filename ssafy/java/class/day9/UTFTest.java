package com.ssafy.day9;

import java.io.IOException;
import java.io.InputStreamReader;

public class UTFTest {

	public UTFTest() {
//		ab가1 => 5바이트 유닉스
//		ab%EA%B0%801
//		61(01010001) 62 EA(11101010) B0 80 31
//		가 = EA B0 80
		
//		기본적으로 char 2byte, UTF-8; // ms-949
//		Stream
//		'\u0061' => 'a', '\u0062" => 'b', '\u00EA', '\u00B0', '\u0080', '\u0031'
//		ab???1
		
//		reader 이용
//		'\u0061' => 'a', '\u0062" => 'b', '\uEAB080', '\u0031'
//		문자열 1바이트의 값이 80(10000000)이 넘는 글자를 합쳐서 표현
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader br = new InputStreamReader(System.in, "utf-8"); // 문자열 셋을 줌.
		new UTFTest();
	}
}
