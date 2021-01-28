package com.ssafy;

public class ContainerTest {
	public static void main(String[] args) {
		StringContainer sc1 = new StringContainer();
		sc1.setObj("String");
//		sc1.setObj(new Integer()); 
		
		GenericContainer<Integer> gc1 = new GenericContainer<>();
		gc1.setObj(3);
		
		GenericContainer<String> gc2 = new GenericContainer<>();
		gc2.setObj("Generic");
	}
}
