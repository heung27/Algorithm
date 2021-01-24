package com.ssafy.ws01.step3;

public class DigitTest2 {
	public static void main(String[] args) {
		int num = 1;
		for (int i=2; i>=-2; i--) {
			for (int j=0; j<5; j++) {
				int x = 2-Math.abs(i);
				if (j >= x &&  j < 5-x) {
					System.out.print(num++);
				}
				else System.out.print(" ");
				
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
