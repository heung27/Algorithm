package com.ssafy.ws08.step3;

import java.util.ArrayList;

import com.ssafy.ws08.step3.Book;
import com.ssafy.ws08.step3.BookManagerImpl;

public class BookTest {
	public static void main(String[] args) {
//		추가된 정보 확인용
//		BookManager를 싱글톤 디자인 패턴을 적용하세요.
		BookManagerImpl manager = BookManagerImpl.getInstance();
		
////		이름이 없는 객체, 어너미어스 오브젝트
//        manager.add(new Book("21424","java Pro", 
//                "김하나1","ssafy.com",15000,"자바 기본문법",5));
//        manager.add(new Magazine("31424","java add web", 
//                "김하나2","ssafy.com",15000,"자바 기본문법", 4, 2010, 5));
//        manager.add(new Book("41424","java Pro", 
//                "김하나3","ssafy.com",15000,"자바 기본문법", 7));
//        manager.add(new Book("51424","java Pro", 
//                "김하나4","ssafy.com",15000,"자바 기본문법", 6));
//        manager.add(new Magazine("51424","java add Pro", 
//                "김하나5","ssafy.com",15000,"자바 기본문법", 8, 2021, 1));
//        manager.add(new Book("51424","java Pro", 
//                "김하나6","ssafy.com",15000,"자바 기본문법", 3));
        
        
//      잡지가 아닌 책들만 골라서 주기
        ArrayList<Book> list6 = manager.getBooks();
        System.out.println("**********잡지가 아닌 책*********");
        for (Book book : list6) {
        	System.out.println(book);
        }
        
        ArrayList<Book> list2 = manager.getMagazines();
        System.out.println("**********잡지인 책*********");
        for (Book book : list2) {
        	System.out.println(book);
        }
        
        int tot = manager.getTotalPrice();
        System.out.println("합계 : "+tot);
        
        double avg = manager.getPriceAvg();
        System.out.printf("전체 평균 %.2f\n", avg);
       
//        타이틀 검색해서 리스트 출력
        System.out.println("************타이틀 검색 출력***************");
        ArrayList<Book> list0 = manager.searchByTitle("add");
        for (Book book : list0) {
        	System.out.println(book);
        }
        
        System.out.println("**********책 리스트*********");
        ArrayList<Book> list = manager.getList();
        for (Book book : list) {
        	System.out.println(book);
        }
        
        System.out.println("***************************************");
        manager.add(new Book("61424","java Pro", 
                "김하나5","ssafy.com",15000,"자바 기본문법", 5));
        list = manager.getList();
        for (Book book : list) {
        	System.out.println(book);
        }
        
        String isbn = "31424";
        Book book = manager.searchByIsbn(isbn);
        System.out.println("************************도서조회"+isbn+"**********************");
        if (book != null) System.out.println(book);
        else System.out.println("검색된 목록이 없습니다.");
        
//      수정, isbn, title
//      isbn에 해당하는 title 수정하기
        manager.update("31424", "수정된 타이틀");
        System.out.println("******************수정 후 리스트*********************");
        list = manager.getList();
        for (Book b : list) {
        	System.out.println(b);
        }
        
        manager.remove(isbn);
        System.out.println("************************도서삭제"+isbn+"**********************");
        list = manager.getList();
        for (Book b : list) {
        	System.out.println(b);
        }
        
        try {
        	manager.buy("21421", 100);
        }catch (ISBNNotFoundException e) {
        	System.err.println(e);
        }finally {
        	System.out.println("************************도서구매"+isbn+"**********************");
        	for (Book b : list) {
            	System.out.println(b);
            }
        }
        
        try {
        	manager.sell("21424", 6);
        }catch (ISBNNotFoundException e) {
        	System.err.println(e);
        }catch (QuantitiyException e) {
        	System.err.println(e);
        }finally {
        	System.out.println("************************도서판매"+isbn+"**********************");
        	for (Book b : list) {
            	System.out.println(b);
            }
        } 
        
        System.out.println("************************데이터 저장**********************");
        manager.saveData();
	}
}
