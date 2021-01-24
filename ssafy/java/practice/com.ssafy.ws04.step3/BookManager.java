package com.ssafy.ws04.step3;

import java.util.Arrays;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int current = 0;
	
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
		if(current < MAX_SIZE) {
			books[current++] = book;
		}
	}
	
	public void remove(String isbn) {
//		순서를 유지하면서 삭제
		for (int i=0; i<current; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				for (int j=i; j<current-1; j++) {
					books[j] = books[j+1]; 
				}
				books[current-1] = null;
				current--;
				break;
			}
		}
		System.out.println("삭제완료");
		return;
	}
	
	public Book[] getList() {
		Book[] temps = Arrays.copyOf(books, current);
//		Book[] temps = new Book[current];
//		for (int i=0; i<current; i++) {
//			temps[i] = books[i];
//		}
//		System.arraycopy(books, 0, temps, 0, current);
		return temps;
	}
	
	public Book searchByIsbn(String isbn) {
		for (int i=0; i<current; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				return books[i];
			}
		}
		return null;
	}
	
	public void update(String isbn, String title) {
		for (int i=0; i<current; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				books[i].setTitle(title);
			}
		}
	}
}
