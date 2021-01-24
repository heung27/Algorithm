package com.ssafy.ws01.step3;

public class DigitTest1 {
	public static void main(String[] args) {
		int num = 1;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (j < i) System.out.print(" ");
				else System.out.print((num++));
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
