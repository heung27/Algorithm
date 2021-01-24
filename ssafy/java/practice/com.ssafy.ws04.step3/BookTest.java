package com.ssafy.ws04.step3;

public class BookTest {
	public static void main(String[] args) {
//		추가된 정보 확인용
//		BookManager를 싱글턴 디자인 패턴을 적용하세요.
		BookManager manager = BookManager.getInstance();
//		BookManager manager = new BookManager();
		System.out.println("****************도서목록******************");
		
//		이름이 없는 객체, 어너미어스 오브젝트
        manager.add(new Book("21424","java Pro", 
                "김하나1","ssafy.com",15000,"자바 기본문법"));
        manager.add(new Book("31424","java Pro", 
                "김하나2","ssafy.com",15000,"자바 기본문법"));
        manager.add(new Book("41424","java Pro", 
                "김하나3","ssafy.com",15000,"자바 기본문법"));
        manager.add(new Book("51424","java Pro", 
                "김하나4","ssafy.com",15000,"자바 기본문법"));
        
        Book[] list = manager.getList();
        for (Book book : list) {
        	System.out.println(book); // 알아서 toString()을 찾는다. (상속)
        }
		
        System.out.println("***************************************");
        manager.add(new Book("61424","java Pro", 
                "김하나5","ssafy.com",15000,"자바 기본문법"));
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
        
	}
}
