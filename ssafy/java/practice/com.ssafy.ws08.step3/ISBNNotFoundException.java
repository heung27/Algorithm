package com.ssafy.ws08.step3;

public class ISBNNotFoundException extends Exception {
	private String isbn;
	public ISBNNotFoundException(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
}
