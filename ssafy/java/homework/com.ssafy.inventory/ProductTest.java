package com.ssafy.inventory;

public class ProductTest {
	public static void main(String[] args) {
		TV[] tv = new TV[2];
		Refrigerator[] ref = new Refrigerator[2];
		
		tv[0] = new TV(1234, "삼성tv", 1000, 5, 55, "LED");
		tv[1] = new TV(5678, "엘지tv", 800, 4, 48, "LCD");
		
		ref[0] = new Refrigerator(1111, "김치 냉장고", 1200, 2, 700);
		ref[1] = new Refrigerator(2222, "일반 냉장고", 800, 3, 500);
		
		System.out.println("[TV 목록]");
		System.out.println("제품번호\t|\t제품이름\t|\t가격\t|\t수량\t|\t인치\t|\t디스플레이 타입");
		for (TV t : tv) {
			System.out.println(t);
		}
		System.out.println();
		System.out.println("[냉장고 목록]");
		System.out.println("제품번호\t|\t제품이름\t|\t가격\t|\t수량\t|\t용량");
		for (Refrigerator r : ref) {
			System.out.println(r);
		}
	}
}
