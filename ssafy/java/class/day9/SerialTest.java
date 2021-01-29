package com.ssafy.day9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

// 번외. volatile 변수는 Main Memory에 저장하겠다는 것을 명시.
// 매개변수 값을 Read할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것.
// 또 Write할 때마다 Main Memory에 까지 가서 저장하는 것.


// 이게 같으면 같은 객체, 다르면 다른 객체
// 클래스를 변경하면  다른 값이 생성됨... 전에 저장한 데이터 불러오지 못 함.
class Person implements Serializable { // Serializable는 추상메소드를 가지지 않음.
	/**
	 * 반드시 serialVersionUID 값 랜덤 생성.
	 * 클래스를 변경하더라도 이게 같으면 같은 객체. 새로 추가된 멤버는 디폴트 값을 저장.
	 */
	private static final long serialVersionUID = 2058434517880827039L; 
	String name;
	int age; // 
	transient int privateNumber; // 휘발성 메모리 IO 대상에서 제거
	int level;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", level=" + level + "]";
	}
}

public class SerialTest {
	
	public SerialTest() throws FileNotFoundException, IOException, ClassNotFoundException {
		Person person = new Person();
		person.age = 25;
		person.name = "abc";
		person.privateNumber = 5678;
//		메모리 상에서만 저장된 것
//		Output을 이용해서 출력
//		모니터(표준), 파일, 네트워크
//		person 객체를 파일에 저장
//		Stream은 모든 정보를 byte[] 배열로 전송
//		객체 입출력에 사용되는 입출력 객체가 바로 ObjectInput(Output)Stream
//		현제폴더에 sam.dat에 보관
		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sam.dat"));
////		ObjectOutputStream 메소드에서 writeObject만 사용하세요.
//		oos.writeObject(person);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sam.dat"));
		Person newPerson = (Person)ois.readObject();
		System.out.println(newPerson);
//		
		System.out.println("end");
	}
	public static void main(String[] args) throws Exception {
		new SerialTest();
	}
}
