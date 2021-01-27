package com.ssafy.ws05.step4;

import java.util.ArrayList;

class SBook {
	String name;
	int price;
	public SBook(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "SBook [name=" + name + ", price=" + price + "]";
	}
}

public class ArrayListTest {
	public ArrayListTest() {
		ArrayList<SBook> list = new ArrayList<>();
//		C,R,U,D
//		추가
		list.add(new SBook("A", 1000));
		list.add(new SBook("B", 1000));
		list.add(new SBook("C", 1000));
		list.add(new SBook("D", 1000));
		
//		접근
		System.out.println(list.get(0));
		System.out.println("*******************");
//		전체 갯수
		System.out.println(list.size());
		System.out.println("*******************");
//		마지막 항목
		System.out.println(list.get(list.size()-1));
		System.out.println("*******************");
//		전체 출력
		for (SBook book : list) {
			System.out.println(book);
		}
		System.out.println("*******************");
//		삭제
		list.remove(2);
		for (SBook book : list) {
			System.out.println(book);
		}
		System.out.println("*******************");
//		수정
		list.set(2, new SBook("수정 타이틀", 7000));
		for (SBook book : list) {
			System.out.println(book);
		}
		System.out.println("*******************");
//		두 번째의 가격만 수정하고 싶다.
		list.get(2).price = 9000;
		for (SBook book : list) {
			System.out.println(book);
		}
	}
	
	public static void main(String[] args) {
		new ArrayListTest();
	}
}
