package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

class MySortComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
//		return o1 - o2; // 오름차순 boxing, unboxing이 이루어지고 있음.
		return o1.intValue() - o2.intValue(); // 오름차순 
		
//		return -(o1 - o2); // 내림차순
//		return o2.intValue() - o1.intValue(); // 내림차순 
	}
	
}

public class CompareTest {
//	MySortComparator comparator = new MySortComparator();
//	MySortComparator comparator = new Comparator<Integer>() {
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return o1.intValue() - o2.intValue(); // 오름차순 
//	};
	public CompareTest() {
		Integer[] arr = {1,4,5,7,2};
		// 순서로 정렬하라
//		[1,2,4,5,7]; 오름차순
//		[7,5,4,2,1]; 내림차순
//		Arrays.sort(arr);
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue(); // 오름차순 
			}
		});
//		Arrays.sort(arr, comparator); // int배열은 안됨. Integer배열로 수정.
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		new CompareTest();
	}
}
