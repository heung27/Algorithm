package com.ssafy.inventory;

public class TV {
	private int number;
	private String name;
	private int price;
	private int cnt;
	private int inch;
	private String type;
	
	public TV(int number, String name, int price, int cnt, int inch, String type) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		this.inch = inch;
		this.type = type;
	}
	
	public String toString() {
		String res = number + "\t|\t " + name + "\t|\t " + price + "\t|\t " + cnt + "\t|\t " + inch + "\t|\t " + type;
		return res;
	}
}
