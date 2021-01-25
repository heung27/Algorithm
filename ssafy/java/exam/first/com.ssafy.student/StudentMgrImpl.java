package com.ssafy.student;

import java.util.Arrays;

public class StudentMgrImpl {
	private static StudentMgrImpl manager = null;
	/** 교육생정보를 저장하기 위한 배열 */
	private Student[] students = new Student[100];
	/** 저장된 교육생 정보의 갯수를 기억하는 변수 */
	private int index = 0;

	private StudentMgrImpl() {}
	
	public static StudentMgrImpl getInstance() {
		if (manager == null) {
			manager = new StudentMgrImpl();
		}
		return manager;
	}
	
	/** 교육생 정보를 저장하는 메서드 */
	public void add(Student student) {
		// 구현 하세요.
		if (index < 100)
			students[index++] = student;
	}

	/** 모든 교육생 정보를 리턴하는 메서드 */
	public Student[] search() {
		Student[] newStudents = new Student[index];
		newStudents = Arrays.copyOf(students, index);
		// 구현 하세요.
		return newStudents;
	}

	/** 저장된 교육생정보 중 교육생번호를 검색하여 리턴하는 메서드 */
	public Student search(int studentNo) {

		// 구현 하세요.
		for (int i=0; i<index; i++) {
			if (students[i].getStudentNo() == studentNo) {
				return students[i];
			}
		}
		return null;
	}

	/** 저장된 교육생정보 중 교육생이름을 검색하여 리턴하는 메서드 */
	public Student[] search(String name) {
		Student[] newStudents = null;
		Student[] temp = new Student[index];
		int cnt = 0;
		// 구현 하세요.
		for (int i=0; i<index; i++) {
			if (students[i].getName().equals(name)) {
				temp[cnt] = students[i];
				cnt++;
			}
		}
		newStudents = new Student[cnt];
		newStudents = Arrays.copyOf(temp, cnt);
		return newStudents;
	}

	/** 저장된 교육생정보 중 교육생번호를 검색하여 지역과 반번호를 수정하는 메서드 */
	public boolean update(int studentNo, String area, int classNo) {

		// 구현 하세요.
		for (int i=0; i<index; i++) {
			if (students[i].getStudentNo() == studentNo) {
				students[i].setArea(area);
				students[i].setClassNo(classNo);
				return true;
			}
		}
		return false;
	}

	/** 저장된 교육생정보 중 교육생번호를 검색하여 교육생을 삭제하는 메서드 */
	public boolean delete(int studentNo) {

		// 구현 하세요.
		for (int i=0; i<index; i++) {
			if (students[i].getStudentNo() == studentNo) {
				for (int j=i; j<index-1; j++) {
					students[j] = students[j+1];
				}
				students[index-1] = null;
				index--;
				return true;
			}
		}
		return false;
	}

}

