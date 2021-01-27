package com.ssafy.hw07;

import java.util.ArrayList;

public class ProductMgrImpl implements  IProductMgr{
	private static ProductMgrImpl manager;
	private ArrayList<Product> products;
	
	private ProductMgrImpl() {
		products = new ArrayList<>();
	}
	
	public static ProductMgrImpl getInstance() {
		if (manager == null) manager = new ProductMgrImpl();
		return manager;
	}
	
	public void add(Product p) {
		products.add(p);
	}
	
	public void list() {
		for (Product p : products) {
			System.out.println(p);
		}
	}
	
	public void list(int num) {
		for (Product p : products) {
			if (p.getNumber() == num) {
				System.out.println(p);
				break;
			}
		}
	}
	
	public void list(String name) {
		for (Product p : products) {
			if (p.getName().contains(name)) {
				System.out.println(p);
			}
		}
	}
	
	public void listTV() {
		for (Product p : products) {
			if (p instanceof TV) {
				System.out.println(p);
			}
		}
	}
	
	public void listRef() {
		for (Product p : products) {
			if (p instanceof Refrigerator) {
			System.out.println(p);
			}
		}
	}
	
	public void overCapacity() { // 냉장고
		for (Product p : products) {
			if (p instanceof Refrigerator) {
				if (((Refrigerator) p).getCapacity() >= 400) {
					System.out.println(p);
				}
			}
		}
	}
	
	public void overInch() { // TV
		for (Product p : products) {
			if (p instanceof TV) {
				if (((TV) p).getInch() >= 50) {
					System.out.println(p);
				}
			}
		}
	}
	
	public void update(int num, int price) {
		for (int i=0; i<products.size(); i++) {
			if (products.get(i).getNumber() == num) {
				products.get(i).setPrice(price);
				break;
			}
		}
	}
	
	public void delete(int num) {
		for (int i=0; i<products.size(); i++) {
			if (products.get(i).getNumber() == num) {
				products.remove(i);
				break;
			}
		}
	}
	
	public void totalPrice() {
		int total = 0;
		for (Product p : products) {
			total += p.getPrice();
		}
		System.out.println(total);
	}
}
