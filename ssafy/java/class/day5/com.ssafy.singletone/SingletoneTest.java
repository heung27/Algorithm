package com.ssafy.singletone;

public class SingletoneTest {
	public static void main(String[] args) {
		
//		Teacher teacher1 = new Teacher();
		Teacher teacher1 = Teacher.getInstance(); // 여기가 포인트
		teacher1.name = "김재웅";
		teacher1.location = "구미";
		
		Student student1 = new Student();
		student1.name = "남상윤";
		student1.age = 26;
		student1.teacher = teacher1;
		
//		Teacher teacher2 = new Teacher();
		Teacher teacher2 = Teacher.getInstance(); // 여기가 포인트
		teacher2.name = "박재웅";
		teacher2.location = "구미";
		
		Student student2 = new Student();
		student2.name = "강민주";
		student2.age = 25;
		student2.teacher = teacher2;
		
		System.out.println(student1.teacher == student2.teacher); // false => true
		System.out.println("남상윤 샘 : "+student1.teacher.name);
	}
}
