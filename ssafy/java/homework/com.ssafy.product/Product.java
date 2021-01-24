package com.ssafy.product;

public class Product {
	public int number;
	private String name;
	public int price;
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
	
}
