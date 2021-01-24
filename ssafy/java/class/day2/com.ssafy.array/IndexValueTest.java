package com.ssafy.array;

import java.util.Arrays;
import java.util.Scanner;

public class IndexValueTest {
	public static void main(String[] args) {
		// 숫자로만 구성된 문자열을 입력받아서 그 숫자의 입력 개수를 구하여 출력하라
//		1234565667777  7 => 4,
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char ch;
//		누적 변수 0~9까지 이기 때문에 10개 (배열)
//		A : 65, a : 97, 0 : 48
		int[] counts = new int[10];
		int idx;
		for (int i=0; i<input.length(); i++) {
			ch = input.charAt(i);
			
			// 문자를 숫자로 바꾸는 방법 4 가지
			idx = Integer.parseInt(new Character(ch).toString());
//			idx = Integer.parseInt(ch+"");
//			idx = ch - '0';
//			idx = ch - 48;
			
			counts[idx]++; // 포인트
			System.out.println(ch);
		}
		System.out.println(Arrays.toString(counts));
		
		// 다차원 배열의 이해
		// 현업에서 배열은 거의 존재하지 않음(길이가 고정), ArrayList 또는 Collection을 사용
//		int[][][] arr = new int[5][][];
//		
//		arr[0] = new int[3][];
		
		int[][]arr = new int[5][]; // 뒤에 9라고 고정되어 있으면 쓰레기 값이 생김
		
		arr[0] = new int[3];
		arr[1] = new int[7];
		arr[2] = new int[5];
		arr[3] = new int[9];
		arr[4] = new int[6];
		int cnt = 65;
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				arr[i][j] = cnt;
				cnt++;
			}
		}
//		입력, 쳐리, 출력은 항상 분리
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print((char)arr[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int[] temp : arr) {
			for(int data : temp) {
				System.out.print((char)data+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
