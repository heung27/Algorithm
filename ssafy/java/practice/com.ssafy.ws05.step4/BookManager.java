package com.ssafy.ws05.step4;

import java.util.ArrayList;

public class BookManager {
	ArrayList<Book> list = null;
	
	private static BookManager manager = null; // 싱글톤 적용
	
	private BookManager() { // 싱글톤 적용
//		생성하면서 멤버 객체 생성관리
		list = new ArrayList<>();
	}
	
	public static BookManager getInstance() { // 싱글톤 적용
		if (manager == null) {
			manager = new BookManager();
		}
		return manager;
	}
	
	public void add(Book book) {
		list.add(book);
	}
	
	public void remove(String isbn) {
//		순서를 유지하면서 삭제
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getIsbn().equals(isbn)) {
				list.remove(i);
				return;
			}
		}
		return;
	}
	
	public ArrayList<Book> getList() {
		return list;
	}
	
	public Book searchByIsbn(String isbn) {
		for (int i=0; i<list.size(); i++) {
			if (isbn.equals(list.get(i).getIsbn())) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public void update(String isbn, String title) {
		for (int i=0; i<list.size(); i++) {
			if (isbn.equals(list.get(i).getIsbn())) {
				list.get(i).setTitle(title);
			}
		}
	}
	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : list) {
			if (!(book instanceof Magazine)) {
				temp.add(book);
			}
		}
		return temp;
	}
	
	public ArrayList<Book> getMagazines() {
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : list) {
			if (book instanceof Magazine) {
				temp.add(book);
			}
		}
		return temp;
	}
	
	public int getTotalPrice() {
		int tot = 0;
		for (Book book : list) {
			tot += book.getPrice();
		}
		return tot;
	}
	
	public double getPriceAvg() {
		double price = 0;
		int tot = getTotalPrice();
		price = (double)tot / list.size();
		return price;
	}
	
//  이름이 유사한 것 찾아서 반환하기
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		int cnt = 0;
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getTitle().contains(title)) { // contains 문자가 포함되어 있으면 true
				temp.add(list.get(i));
			}
		}
		return temp;
	}
}
