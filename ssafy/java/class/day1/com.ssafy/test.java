package com.ssafy;

public class test {
	public static void main(String[] args) {
		int x = (int) (Math.random()*6)+1;
		System.out.println(x);
		int y = (int) (Math.random()*6)+1;
		System.out.println(y);
		if (x%2 == 0 & y%2 == 0) System.out.println("A");
		if (x%2 != 0 & y%2 != 0) System.out.println("B");
	}
}
