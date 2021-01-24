package com.ssafy;

public class Phone {

	public String name = "Galaxy Note";
	public char color;
	public int price;
	
	public String getNameValue() {
		return name;
	}

	public void setNameValue(String name) {
		this.name = name;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRealDebt() {
		return 1000; 
	}
	
	public Phone(String name) {
		this.name = name;
		System.out.println("A");
		System.out.println(this.name);
	}
	
	public Phone() {
		System.out.println("B");
		System.out.println(this.name);
	}
	
	
}  