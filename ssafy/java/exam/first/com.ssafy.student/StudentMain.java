package com.ssafy.student;

import java.util.Scanner;

public class StudentMain {

	Scanner s = new Scanner(System.in);

	StudentMgrImpl mgr = StudentMgrImpl.getInstance(); // Singleton Pattern 적용시 객체 생성 변경해야 함.

	public static void main(String[] args) {
		StudentMain m = new StudentMain();
		int num = 0;
		while (true) {
			num = m.menu();
			if (num == 0)
				break;
			switch (num) {
			case 1:
				m.insert();
				break;
			case 2:
				m.search();
				break;
			case 3:
				m.searchNum();
				break;
			case 4:
				m.searchName();
				break;
			case 5:
				m.update();
				m.search();
				break;
			case 6:
				m.delete();
				m.search();
				break;
			default:
				System.err.println("메뉴 번호를 정확히 입력해 주세요.");
				continue;
			}

		}
	}

	public int menu() {
		int result = 0;
		System.out.println("==================================");
		System.out.println("========== 교육생 관리 프로그램 ==========");
		System.out.println("==================================");
		System.out.println("1. 교육생 등록");
		System.out.println("2. 교육생 목록 보기");
		System.out.println("3. 교육생 검색(교육생번호로 검색)");
		System.out.println("4. 교육생 검색(이름으로 검색)");
		System.out.println("5. 교육생 수정");
		System.out.println("6. 교육생 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택 하세요.");

		result = s.nextInt();

		return result;

	}

	public void insert() {
		System.out.println("교육생 정보를 입력하세요. 형식:교육생번호(숫자4자리),이름,지역,반번호");
		String[] info = s.next().split(",");

		mgr.add(new Student(Integer.parseInt(info[0]), info[1], info[2], Integer.parseInt(info[3])));

	}

	public void search() {
		System.out.println(">>>>>>>>  교육생 목록 보기 ");
		Student[] students = mgr.search();
		if (students.length == 0) {
			System.err.println("교육생 정보가 없습니다.");
			return;
		}
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void searchNum() {
		System.out.println(">>>>>>>>  교육생  검색 (교육생번호로 검색) ");
		System.out.println("검색하고자하는 교육생번호를 입력하세요.");
		int snum = s.nextInt();
		Student student = mgr.search(snum);
		if (student != null)
			System.out.println(student);
		else
			System.err.println("검색 실패~~~ 교육생번호를 확인하세요.");

	}

	public void searchName() {
		System.out.println(">>>>>>>>  교육생  검색 (이름으로 검색) ");
		System.out.println("검색하고자하는 이름을 입력하세요.");
		
		String sname = s.next();
		Student[] student = mgr.search(sname);
		if (student.length == 0) {
			System.err.println("검색 하고자하는 이름의 교육생 정보가 없습니다.");
		}
		else {
			for (Student s : student) {
				System.out.println(s);
			}
		}
		// 구현 하세요.
	}

	public void update() {
		System.out.println(">>>>>>>>  교육생 정보  수정 ");
		System.out.println("수정하고자하는 교육생의 교육생번호,지역, 반번호를 입력하세요.");
		String[] info = s.next().split(",");
		boolean flag = mgr.update(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2]));
		if (flag)
			System.out.println("정상적으로 수정되었습니다.");
		else
			System.err.println("수정 실패~~~  교육생번호를 확인 하세요.");
	}

	public void delete() {
		System.out.println(">>>>>>>>  교육생 삭제 ");
		System.out.println("삭제하고자하는 교육생의 교육생번호를 입력하세요.");
		int info = s.nextInt();
		boolean flag = mgr.delete(info);
		if (flag)
			System.out.println("정상적으로 삭제되었습니다.");
		else
			System.err.println("삭제 실패~~~  교육생번호를 확인 하세요.");
		// 구현 하세요.

	}

}