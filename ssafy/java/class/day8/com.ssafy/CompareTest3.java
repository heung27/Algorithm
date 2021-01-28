package com.ssafy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Throwable 에러와 예외의 최상위 클래스
// 1. Error (치명적 오류)
// 
// 2. Exception (제어)
//   RuntimeException
//     NullPointException
//   IOException
//   SQLException
//
// Error와 RuntimeException는 unChecked Exception (처리 안해줘도 실행은 됨)
//
// 나머지는 Checked Exception (무조건 처리해줘야 함, 안하면 컴파일 에러)
// 1. try ~ catch ~ finally
// 2. throws
// 3. try ~ catch ~ throw
//


public class CompareTest3 {
	class Student implements Comparable<Student> {
		String name;
		int age;
		
		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}

		@Override
		public int compareTo(Student other) {
			return this.age - other.age;
		}
	}
	
	public CompareTest3() {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("kimi1", 30));
		list.add(new Student("kimi4", 32));
		list.add(new Student("kimi2", 35));
		list.add(new Student("kimi5", 34));
		list.add(new Student("kimi3", 33));
		for (Student s : list) {
			System.out.println(s);
		}
		
		System.out.println("*********************");
		Collections.sort(list); // comparable
		for (Student s : list) {
			System.out.println(s);
		}
		
		System.out.println("*********************");
//		이름순으로 정렬(어너미어스 Local InnerClass 객체 활용)
		Collections.sort(list, new Comparator<Student>() { // comparator
			@Override
			public int compare(Student o1, Student o2) {
				return -o1.name.compareTo(o2.name); // Strintg 내림차순
			}
		});
		for (Student s : list) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		new CompareTest3();
	}
}
