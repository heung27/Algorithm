package com.ssafy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class IData {
	String name;
	int age;
	
	public IData(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "IData [name=" + name + ", age=" + age + "]";
	}
}
public class IteratorTest {
	public IteratorTest() {
		List<IData> list = new ArrayList<>();
		list.add(new IData("kim1",3));
		list.add(new IData("kim7",5));
		list.add(new IData("kim3",9));
		list.add(new IData("kim6",2));
		list.add(new IData("kim4",4));
		for (IData d : list) {
			System.out.println(d);
		}
		System.out.println();
		
		Iterator<IData> iterator = list.iterator();
		while(iterator.hasNext()) {
			IData d = iterator.next();
//			remove가 편리
			System.out.println(d);
		}
	}
	public static void main(String[] args) {
		new IteratorTest();
	}
}
