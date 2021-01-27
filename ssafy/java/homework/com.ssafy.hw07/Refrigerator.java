package com.ssafy.hw07;

public class Refrigerator extends Product {
	private int capacity;
	
	public Refrigerator(int number, String name, int price, int cnt, int capacity) {
		super(number, name, price, cnt);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String toString() {
		String res = super.toString() + "\t|\t" + capacity;
		return res;
	}
}
