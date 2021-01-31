package com.ssafy.ws06.step3;

public interface IBookManager {
	public void add(Book book);
	public void remove(String isbn);
	public Book[] getList();
	public Book searchByIsbn(String isbn);
	public Book[] searchByTitle(String title);
	public Book[] getBooks();
	public Book[] getMagazines();
	public int getTotalPrice();
	public double getPriceAvg();
}
