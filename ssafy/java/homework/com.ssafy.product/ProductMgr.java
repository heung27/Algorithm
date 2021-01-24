package com.ssafy.product;

public class ProductMgr {
	private static ProductMgr manager;
	
	private final int MAX_SIZE = 100;
	private Product[] products = new Product[MAX_SIZE];
	private int cur;
	
	private ProductMgr() {
		
	}
	
	public static ProductMgr getInstance() {
		if (manager == null) manager = new ProductMgr();
		return manager;
	}
	
	public void add(Product P) {
		if (cur < MAX_SIZE) {
			products[cur++] = P;
		}
	}
	
	public void list() {
		for (int i=0; i<cur; i++) {
			System.out.println(products[i]);
		}
	}
	
	public void list(int num) {
		for (int i=0; i<cur; i++) {
			if (products[i].getNumber() == num) {
				System.out.println(products[i]);
				break;
			}
		}
	}
	
	public void delete(int num) {
		for (int i=0; i<cur; i++) {
			if (products[i].getNumber() == num) {
				for (int j=i; j<cur-1; j++) {
					products[j] = products[j+1];
				}
				products[cur-1] = null;
				cur--;
				break;
			}
		}
	}
	
	public void priceList(int price) {
		for (int i=0; i<cur; i++) {
			if (products[i].getPrice() <= price) {
				System.out.println(products[i]);
			}
		}
	}
}
