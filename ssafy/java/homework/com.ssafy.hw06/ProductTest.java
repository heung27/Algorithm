package com.ssafy.hw06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProductTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ProductMgr manager = ProductMgr.getInstance();
		System.out.println("[Abc 디지털 대리점 재고 관리]");
		while (true) {
			System.out.println("작업할 번호 선택 :\n1. add   2. list   3. searchNum   4. searchName   5. delete\n"
					+ "6. TVsearch   7. Refsearch   8. totalPirce   0. 종료");
			int button = Integer.parseInt(br.readLine());
			switch(button) {
			case 0 :
				br.close();
				System.exit(0);
			case 1 : 
				System.out.println("추가할 재고 타입 선택 : 1. TV   2. 냉장고");
				int n = Integer.parseInt(br.readLine());
				switch(n) {
				case 1 :
					System.out.println("추가할 재고 정보를 입력해주세요.\n(상품번호 상품이름 가격 수량 인치 타입 - 스페이스바로 구분)");
					StringTokenizer st1 = new StringTokenizer(br.readLine());
					int add_number1 = Integer.parseInt(st1.nextToken());
					String name1 = st1.nextToken();
					int price1 = Integer.parseInt(st1.nextToken());
					int cnt1 = Integer.parseInt(st1.nextToken());
					int inch1 = Integer.parseInt(st1.nextToken());
					String type1 = st1.nextToken();
					Product p1 = new TV(add_number1, name1, price1, cnt1, inch1, type1);
					manager.add(p1);
					System.out.println("재고 추가 완료");
					break;
				case 2 :
					System.out.println("추가할 재고 정보를 입력해주세요.\n(상품번호 상품이름 가격 수량 용량 - 스페이스바로 구분)");
					StringTokenizer st2 = new StringTokenizer(br.readLine());
					int add_number2 = Integer.parseInt(st2.nextToken());
					String name2 = st2.nextToken();
					int price2 = Integer.parseInt(st2.nextToken());
					int cnt2 = Integer.parseInt(st2.nextToken());
					int capacity2 = Integer.parseInt(st2.nextToken());
					Product p2 = new Refrigerator(add_number2, name2, price2, cnt2, capacity2);
					manager.add(p2);
					System.out.println("재고 추가 완료");
					break;
				default :
					System.out.println("번호를 다시 선택해주세요.");
				}
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
				System.out.println("검색할 상품명을 입력하세요.");
				String list_name = br.readLine();
				manager.list(list_name);
				break;
			case 5 :
				System.out.println("삭제할 상품 번호를 입력하세요.");
				int del_number = Integer.parseInt(br.readLine());
				manager.delete(del_number);
				System.out.println("삭제 완료");
				break;
			case 6 : 
				System.out.println("TV 정보만 검색");
				manager.listTV();
				break;
			case 7 : 
				System.out.println("Refrigerator 정보만 검색");
				manager.listRef();
				break;
			case 8 :
				System.out.print("재고의 전체 금액 : ");
				manager.totalPrice();
				break;
			default :
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
}
