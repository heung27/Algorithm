package com.ssafy.array;

import java.util.Arrays;

public class ObjectTest {
	public static void main(String[] args) {
		// 배열을 만들면 각 항목마다 초기값이 할당된다.
//		기본형 => 기본값, 개체는  null값이 초기화 된다.
		String[] arr = new String[5];
		System.out.println(Arrays.toString(arr));
		
		Data[] drr = new Data[5];
		System.out.println(Arrays.toString(drr));
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = new String("ssafy" + i);
//			arr[i] = "ssafy" + i; 위 와 같은 동작
		}
		for (int i=0; i<arr.length; i++) {
			drr[i] = new Data(); // 이거 없으면 에러
			drr[i].num = i;
		}
		System.out.println("end");
//		for each d는 읽기 전용
		for (Data d : drr) {
			d.num = 4; // d는 읽기 전용이지만 d가 참조하는 것은 바뀔 수 있음
		}
		for (Data d : drr) {
			System.out.println(d.num);
		}
		for (String s : arr) {
			s = "d";
		}
		for (String s : arr) {
			System.out.println(s);
		}
		
//		swap, 최대값, 최소값
		
//		1. 저장한 변수 선언
//		2. a 값을 임시 변수에 넣기
//		3. b 값을 a 넣기
//		4. 임시변수 값을 b에 넣기
		
		int a = 10, b = 20, temp;
		 temp = a;
		 a = b;
		 b = temp;
		 
//		 배열(Collection)에서 최대값 구하기
//		
//		 1. 최대값을 구하는 곳에 얻을 수 있는 최소값을 넣어라
//		 2. 반복하면서 배열의 항목값과 최대값 저장된 값을 비교해서
//		    최대값 보다 항목값이 더 크면, 최대값 변수에 항목값을 넣는다.
//		 3. 2를 배열의 개수 만큼 반복한다.
		 
		 int[] srr = {1, 2, 3, 4, 5};
		 int max = 0;
		 for (int num : srr) {
			 max = Math.max(max, num);
//			 Math.pow(100, 100); 믿으면 안됨 (오버플로 조심)
//			 if (max < num) max = num;
		 }
		 System.out.println(max);
		 
		 int[] trr = {1, 4, 5, 3, 2};
		 
		 int[] zrr = new int[4];
		 // System.arraycopy();
		 // zrr의 배열의 1~2번째 까지의 내용을 trr, 3~4번째 정보로 채워주세요
		 
		 for (int i=1; i<=2; i++) {
			 zrr[i] = trr[i+2];
		 }
		 System.arraycopy(trr, 3, zrr, 1, 2); // 시험에 나옴
		 System.out.println(Arrays.toString(trr));
		 System.out.println(Arrays.toString(zrr));
		 
		 // 정렬
		 
		 Arrays.sort(trr);
		 System.out.println(Arrays.toString(trr));
	}
	static class Data {
		int num = 30;
	}
}
