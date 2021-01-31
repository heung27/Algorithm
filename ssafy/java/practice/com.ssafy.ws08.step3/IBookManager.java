package com.ssafy.ws08.step3;

import java.util.ArrayList;

public interface IBookManager {
	public void add(Book book);
	public void remove(String isbn);
	public ArrayList<Book> getList();
	public Book searchByIsbn(String isbn);
	public ArrayList<Book> searchByTitle(String title);
	public ArrayList<Book> getMagazines();
	public ArrayList<Book> getBooks();
	public int getTotalPrice();
	public double getPriceAvg();
	public void sell(String isbn, int num) throws ISBNNotFoundException, QuantitiyException;
	public void buy(String isbn, int num) throws ISBNNotFoundException;
	public void saveData();
}
