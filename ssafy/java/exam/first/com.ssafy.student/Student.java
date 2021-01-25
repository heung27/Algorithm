package com.ssafy.student;

public class Student {

	private int studentNo;
	private String name;
	private String area;
	private int classNo;

	public Student() {
	}

	public Student(int studentNo, String name, String area, int classNo) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.area = area;
		this.classNo = classNo;
	}
	
	
	// getter/setter 구현 하세요.

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	@Override
	public String toString() {
		// toString() 구현 하세요.
		System.out.println(studentNo + " " + name + " " + area + " " + classNo);
		return "";
	}

}