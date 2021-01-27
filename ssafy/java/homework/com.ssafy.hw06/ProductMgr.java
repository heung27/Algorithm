package com.ssafy.hw06;

public class ProductMgr {
	private static ProductMgr manager;
	
	private final int MAX_SIZE = 100;
	private Product[] products;
	private int size;
	
	private ProductMgr() {
		products = new Product[MAX_SIZE];
	}
	
	public static ProductMgr getInstance() {
		if (manager == null) manager = new ProductMgr();
		return manager;
	}
	
	public void add(Product P) {
		if (size < MAX_SIZE) {
			products[size++] = P;
		}
	}
	
	public void list() {
		for (int i=0; i<size; i++) {
			System.out.println(products[i]);
		}
	}
	
	public void list(int num) {
		for (int i=0; i<size; i++) {
			if (products[i].getNumber() == num) {
				System.out.println(products[i]);
				break;
			}
		}
	}
	
	public void list(String name) {
		for (int i=0; i<size; i++) {
			if (products[i].getName().contains(name)) {
				System.out.println(products[i]);
			}
		}
	}
	
	public void listTV() {
		for (int i=0; i<size; i++) {
			if (products[i] instanceof TV) {
				System.out.println(products[i]);
			}
		}
	}
	
	public void listRef() {
		for (int i=0; i<size; i++) {
			if (products[i] instanceof Refrigerator) {
				System.out.println(products[i]);
			}
		}
	}
	
	public void delete(int num) {
		for (int i=0; i<size; i++) {
			if (products[i].getNumber() == num) {
				for (int j=i; j<size-1; j++) {
					products[j] = products[j+1];
				}
				products[size-1] = null;
				size--;
				break;
			}
		}
	}
	
	public void totalPrice() {
		int total = 0;
		for (int i=0; i<size; i++) {
			total += products[i].getPrice();
		}
		System.out.println(total);
	}
}
