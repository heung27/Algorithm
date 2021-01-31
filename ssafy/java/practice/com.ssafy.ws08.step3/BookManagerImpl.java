package com.ssafy.ws08.step3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookManagerImpl implements IBookManager {
	private ArrayList<Book> books = new ArrayList<>();
	
	private static BookManagerImpl manager = null; // 싱글톤 적용
	
	private BookManagerImpl() { // 싱글톤 적용
		loadData();
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
	
	private void loadData() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("book.dat")))) {
			System.out.println("**********불러온 도서 전체 목록*********");
			String data = null;
			while ((data = br.readLine()) != null) {
				String[] val = data.split("\t \\| ");
				Book book = null;
				if (val.length == 7) {
					book = new Book(val[0], val[1], val[2], val[3], Integer.parseInt(val[4]), val[5], Integer.parseInt(val[6]));
				}
				else if(val.length == 9) {
					book = new Magazine(val[0], val[1], val[2], val[3], Integer.parseInt(val[4]), val[5], Integer.parseInt(val[6]), Integer.parseInt(val[7]), Integer.parseInt(val[8]));
				}
				books.add(book);
			}
			for (Book book : books) {
				System.out.println(book.toString());
			}
		} catch(FileNotFoundException e) {
			System.err.println("등록된 도서가 없습니다.");
		} catch(IOException e) {
			System.err.println("입출력 오류." + e);
		} catch(NumberFormatException e) {
			System.err.println("데이터 형식이 맞지 않습니다." + e);
		}
	}
	
	public void saveData() {
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("book.dat")))) {
			for (Book book : books) {
				String data = book.toString();
				pw.println(data);
			}
			System.out.println("데이터 save");
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다."+ e);
		}
	}
}
