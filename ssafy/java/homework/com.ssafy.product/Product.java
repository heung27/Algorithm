package com.ssafy.product;

public class Product {
	private int number;
	private String name;
	private int price;
	private int cnt;
	
	public Product(int number, String name, int price, int cnt) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + ", cnt=" + cnt + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
