package com.ssafy.inventory;

public class Refrigerator {
	private int number;
	private String name;
	private int price;
	private int cnt;
	private int capacity;
	
	public Refrigerator(int number, String name, int price, int cnt, int capacity) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		this.capacity = capacity;
	}
	
	public String toString() {
		String res = number + "\t|\t" + name + "\t|\t" + price + "\t|\t" + cnt + "\t|\t" + capacity;
		return res;
	}
}
