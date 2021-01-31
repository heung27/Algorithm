package com.ssafy.ws07.step3;

import java.util.ArrayList;

public class BookManagerImpl implements IBookManager {
	private ArrayList<Book> books = new ArrayList<>();
	
	private static BookManagerImpl manager = null; // 싱글톤 적용
	
	private BookManagerImpl() { // 싱글톤 적용
		
	}
	
	public static BookManagerImpl getInstance() { // 싱글톤 적용
		if (manager == null) {
			manager = new BookManagerImpl();
		}
		return manager;
	}
	
	public void add(Book book) {
		books.add(book);
	}
	
	public void remove(String isbn) {
		for (int i=0; i<books.size(); i++) {
			if (isbn.equals(books.get(i).getIsbn())) {
				books.remove(i);
			}
		}
		System.out.println("삭제완료");
		return;
	}
	
	public ArrayList<Book> getList() {
		return books;
	}
	
	public Book searchByIsbn(String isbn) {
		for (Book book : books) {
			if (isbn.equals(book.getIsbn())) {
				return book;
			}
		}
		return null;
	}
	
	public void update(String isbn, String title) {
		for (Book book : books) {
			if (isbn.equals(book.getIsbn())) {
				book.setTitle(title);
			}
		}
	}
	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : books) {
			if (!(book instanceof Magazine)) {
				temp.add(book);
			}
		}
		return temp;
	}
	
	public ArrayList<Book> getMagazines() {
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : books) {
			if (book instanceof Magazine) {
				temp.add(book);
			}
		}
		return temp;
	}
	
	public int getTotalPrice() {
		int tot = 0;
		for (Book book : books) {
			tot += book.getPrice();
		}
		return tot;
	}
	
	public double getPriceAvg() {
		double price = 0;
		int tot = getTotalPrice();
		price = (double)tot / books.size();
		return price;
	}
	
//  이름이 유사한 것 찾아서 반환하기
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : books) {
			if (book.getTitle().contains(title)) { // contains 문자가 포함되어 있으면 true
				temp.add(book);
			}
		}
		return temp;
	}
	
	public void buy(String isbn, int num) throws ISBNNotFoundException {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				book.setQuantity(book.getQuantity()+num);
				return;
			}
		}
		throw new ISBNNotFoundException(isbn);
	}
	
	public void sell(String isbn, int num) throws ISBNNotFoundException, QuantitiyException {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				int amount = book.getQuantity()-num;
				if (amount < 0) throw new QuantitiyException("재고가 부족합니다.");
				else book.setQuantity(amount);
				return;
			}
		}
		throw new ISBNNotFoundException(isbn);
	}
}
