package com.ssafy.ws03.step3;

public class BookTest {
	public static void main(String[] args) {
		System.out.println("***************도서목록***************");
		
		Book book1 = new Book();
		book1.isbn = "2142";
		book1.title = "java";
		book1.author = "홍길동";
		book1.publisher = "삼성출판사";
		book1.price = 2000;
		book1.desc = "기본 문법";
		
		Book book2 = new Book("2222", "알고리즘", "김싸피", "자바출판사", 3000, "설명");
		
//		System.out.println(book1.toString());
//		System.out.println(book2);
		
		Book[] books = new Book[3];
		books[0] = book1;
		books[1] = book2;
		books[2] = new Book("2222", "알고리즘1", "김싸피", "자바출판사", 3000, "설명");
		
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
