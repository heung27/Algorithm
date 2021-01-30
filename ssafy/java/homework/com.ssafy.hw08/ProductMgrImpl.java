package com.ssafy.hw08;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	private static ProductMgrImpl manager;
	private ArrayList<Product> products;
	
	private ProductMgrImpl() {
		products = new ArrayList<>();
	}
	
	public static ProductMgrImpl getInstance() {
		if (manager == null) manager = new ProductMgrImpl();
		return manager;
	}
	
	public void add(Product p) throws DuplicateException {
		if (products.contains(p)) {
			throw new DuplicateException("예외 발생! 이미 존재하는 상품입니다.");
		}
		products.add(p);
	}
	
	public void list() {
		for (Product p : products) {
			System.out.println(p);
		}
	}
	
	public void list(int num) throws CodeNotFoundException {
		for (Product p : products) {
			if (p.getNumber() == num) {
				System.out.println(p);
				return;
			}
		}
		throw new CodeNotFoundException("예외 발생! 상품 번호가 존재하지 않습니다.");
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
	
	public void overCapacity() throws ProductNotFoundException { // 냉장고
		int cnt = 0;
		for (Product p : products) {
			if (p instanceof Refrigerator) {
				if (((Refrigerator) p).getCapacity() >= 400) {
					System.out.println(p);
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			throw new ProductNotFoundException("예외 발생! 상품이 존재하지 않습니다.");
		}
	}
	
	public void overInch() throws ProductNotFoundException { // TV
		int cnt = 0;
		for (Product p : products) {
			if (p instanceof TV) {
				if (((TV) p).getInch() >= 50) {
					System.out.println(p);
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			throw new ProductNotFoundException("예외 발생! 상품이 존재하지 않습니다.");
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
