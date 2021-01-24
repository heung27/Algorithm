package com.ssafy.product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProductTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		ProductMgr manager = new ProductMgr();
		ProductMgr manager = ProductMgr.getInstance();
		System.out.println("[Abc 디지털 대리점 재고 관리]");
		while (true) {
			System.out.println("작업할 번호 선택 : 1. add   2. list   3. search   4. delete   5. priceSearch   0. 종료");
			int button = Integer.parseInt(br.readLine());
			switch(button) {
			case 0 :
				br.close();
				System.exit(0);
			case 1 : 
				System.out.println("추가할 재고 정보를 입력해주세요.\n(상품번호 상품이름 가격 수량 - 스페이스바로 구분)");
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int add_number = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				Product p = new Product(add_number, name, price, cnt);
				manager.add(p);
				System.out.println("재고 추가 완료");
				break;
			case 2 :
				manager.list();
				break;
			case 3 :
				System.out.println("검색할 상품 번호를 입력하세요.");
				int list_number = Integer.parseInt(br.readLine());
				manager.list(list_number);
				break;
			case 4 :
				System.out.println("삭제할 상품 번호를 입력하세요.");
				int del_number = Integer.parseInt(br.readLine());
				manager.delete(del_number);
				System.out.println("삭제 완료");
				break;
			case 5 :
				System.out.println("검색할 재고 가격을 입력하세요. (입력한 가격 이하의 상품 검색)");
				int price_number = Integer.parseInt(br.readLine());
				manager.priceList(price_number);
			}
		}
	}
}
