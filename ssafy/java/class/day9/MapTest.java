package com.ssafy.day9;

import java.util.HashMap;
import java.util.Set;

class Data {
	String id;
	String name;
	int age;
	
	public Data(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}

public class MapTest {

	public MapTest() {
		HashMap<String, Data> map = new HashMap<>();
		
		Data d = new Data("a001", "kim", 30);
		map.put(d.id, d);
		d = new Data("a002", "kim2", 30);
		map.put(d.id, d);
		d = new Data("a002", "kim3", 40); // update
		map.put(d.id, d);
		d = new Data("a004", "kim4", 30);
		map.put(d.id, d);
		
		System.out.println(map.size());
		
		Data res = map.get("a002");
		System.out.println(res);
		map.remove("a002");
		
		res = map.get("a002");
		if (res != null) {
			System.out.println(res);
		}
		else {
			System.out.println("지정된 목록이 없습니다.");
//			사용자 정의 익셉션 생성 및 throw
		}
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(map.get(key));
		}
	}
	
	public static void main(String[] args) {
		new MapTest();
	}
}
