package com.ssafy.array;

public class lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		boolean[] check = new boolean[46];
		for (int i=0; i<6; i++) {
			int num = (int)(Math.random()*45)+1;
			if (!check[num]) {
				lotto[i] = num;
				check[num] = true;
			}
		}
		for (int x : lotto) System.out.print(x+" ");
	}
}
