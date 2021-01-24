package com.java.first;

public class CircleArea {
	public static void main(String[] args) {
		int r = 5;
		double area = Math.pow(r, 2) * Math.PI;
		String str = String.format("%.1f", area);
		System.out.println("반지름이 5cm인 원의 넓이는 "+str+"cm^2입니다.");
	} 
}
