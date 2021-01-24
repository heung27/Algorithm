package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stature = sc.nextInt();
		int weight = sc.nextInt();
		int figure = weight + 100 - stature;
		System.out.println("비만수치는 " + figure + "입니다.");
		if (figure > 0) System.out.println("당신은 비만이군요");
		sc.close();
	}
}
