package com.ssafy.ws05.step3;

import java.util.Arrays;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
//	private int magazineSize = 0;
	
	private static BookManager manager = null; // 싱글톤 적용
	
	private BookManager() { // 싱글톤 적용
		
	}
	
	public static BookManager getInstance() { // 싱글톤 적용
		if (manager == null) {
			manager = new BookManager();
		}
		return manager;
	}
	
	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
		}
	}
	
	public void remove(String isbn) {
//		순서를 유지하면서 삭제
		for (int i=0; i<size; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				for (int j=i; j<size-1; j++) {
					books[j] = books[j+1]; 
				}
				books[size-1] = null;
				size--;
				break;
			}
		}
		System.out.println("삭제완료");
		return;
	}
	
	public Book[] getList() {
		Book[] temps = Arrays.copyOf(books, size);
//		Book[] temps = new Book[current];
//		for (int i=0; i<current; i++) {
//			temps[i] = books[i];
//		}
//		System.arraycopy(books, 0, temps, 0, current);
		return temps;
	}
	
	public Book searchByIsbn(String isbn) {
		for (int i=0; i<size; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				return books[i];
			}
		}
		return null;
	}
	
	public void update(String isbn, String title) {
		for (int i=0; i<size; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				books[i].setTitle(title);
			}
		}
	}
	
	public Book[] getBooks() {
		Book[] temp;
		int cnt = 0;
		for (Book book : books) {
			if (book != null) {
				if (!(book instanceof Magazine)) {
					cnt++;
				}
			}
		}
		temp = new Book[cnt];
		int idx = 0;
		for (Book book : books) {
			if (book != null) {
				if (!(book instanceof Magazine)) {
					temp[idx] = book;
					idx++;
				}
			}
		}
		return temp;
	}
	
	public Book[] getMagazines() {
		Book[] temp;
		int cnt = 0;
		for (Book book : books) {
			if (book != null) {
				if (book instanceof Magazine) {
					cnt++;
				}
			}
		}
		temp = new Book[cnt];
		int idx = 0;
		for (Book book : books) {
			if (book != null) {
				if (book instanceof Magazine) {
					temp[idx] = book;
					idx++;
				}
			}
		}
		return temp;
	}
	
	public int getTotalPrice() {
		int tot = 0;
		for (int i=0; i<size; i++) {
			tot += books[i].getPrice();
		}
		return tot;
	}
	
	public double getPriceAvg() {
		double price = 0;
		int tot = getTotalPrice();
		price = (double)tot / size;
		return price;
	}
	
//  이름이 유사한 것 찾아서 반환하기
	public Book[] searchByTitle(String title) {
		Book[] temp = null;
		int cnt = 0;
		for (int i=0; i<size; i++) {
			if (books[i].getTitle().contains(title)) { // contains 문자가 포함되어 있으면 true
				cnt++;
			}
		}
		temp = new Book[cnt];
		int idx = 0;
		for (int i=0; i<size; i++) {
			if (books[i].getTitle().contains(title)) { // contains 문자가 포함되어 있으면 true
				temp[idx] = books[i];
				idx++;
			}
		}
		return temp;
	}
}
