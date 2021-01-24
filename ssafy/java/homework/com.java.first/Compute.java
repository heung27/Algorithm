package com.java.first;

import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("곱=" + x*y);
		System.out.println("몫" + x/y);
		sc.close();
	}
}
