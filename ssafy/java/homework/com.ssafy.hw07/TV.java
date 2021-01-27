package com.ssafy.hw07;

public class TV extends Product {
	private int inch;
	private String type;
	
	public TV(int number, String name, int price, int cnt, int inch,
			String type) {
		super(number, name, price, cnt);
		this.inch = inch;
		this.type = type;
	}
	
	public int getInch() {
		return inch;
	}



	public void setInch(int inch) {
		this.inch = inch;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String toString() {
		String res =  super.toString() + "\t|\t " + inch + "\t|\t " + type;
		return res;
	}
}
