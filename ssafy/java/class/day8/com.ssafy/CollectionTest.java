package com.ssafy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {
	public static void main(String[] args) {
//		List<String> list = new ArrayList<>();
//		Set<String> list = new HashSet<>();
//		Set<String> list = new TreeSet<>();
//		
//		list.add("ssafy");
//		list.add("java");
//		list.add("algo");
//		list.add("project");
//		list.add("algo");
//		
//		for (String s : list) {
//			System.out.println(s);
//		}
		
		Set<Data> dList1 = new HashSet<>(); // equals를 정의 하였지만 hashcode를 계산하면 각각의 객체는 다름.
		dList1.add(new Data(1)); 
		dList1.add(new Data(1));
		dList1.add(new Data(1));
		dList1.add(new Data(1));
		System.out.println(dList1.size());
		for (Data d : dList1) {
			System.out.println(d);
		}
		
//		Set<Data> dList = new TreeSet<>();
//		dList.add(new Data(1)); // err. comparable을 안해놨음. String은 이미 구현되어져 있음.
//		dList.add(new Data(1));
//		dList.add(new Data(1));
//		dList.add(new Data(1));
//		System.out.println(dList.size()); // equals를 정의 하니까 모두 중복 처리.
//		for (Data d : dList) {
//			System.out.println(d);
//		}
		
		Set<Data> dList = new TreeSet<>();
	    dList.add(new Data(1));
	    dList.add(new Data(2));
	    dList.add(new Data(4));
	    dList.add(new Data(3));
	    System.out.println(dList.size());
	    for(Data d : dList) {
	        System.out.println(d.num);
	    }
	}
}

class Data implements Comparable<Data> {
	int num;
	Data(int num) {
		this.num = num;
	}
	@Override
	public boolean equals(Object obj) {
		Data d = (Data)obj;
		return this.num == d.num;
	}
	@Override
	public int compareTo(Data o) {
		return this.num - o.num;
	}
}