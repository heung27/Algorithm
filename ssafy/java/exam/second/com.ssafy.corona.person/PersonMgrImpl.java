package com.ssafy.corona.person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonMgrImpl implements PersonMgr {
	private List<Person> people;
	
	private static PersonMgr instance=new PersonMgrImpl();
	
	private PersonMgrImpl() {
		people=new ArrayList<Person>();
	}
	public static PersonMgr getInstance() {
		return instance;
	}
	
	@Override
	public void add(Person p) {
		people.add(p);
	}
	@Override
	public List<Person> search() {
		return people;
	}	
	@Override
	public Person search(String name) {
		for(Person p : people) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	@Override
	public void delete(String name) {
		for(int i=people.size()-1; i>=0; i--) {
			if(people.get(i).getName().equals(name)) {
				people.remove(i);
			}
		}
	}	
	@Override
	public void load() {
		File f=new File("people.dat");
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))){
				people = (ArrayList<Person>)ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("[SYSTEM] 파일 읽기 실패");
			}
		}
//		else people=new ArrayList<Person>();
	}
	@Override
	public void save() {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("people.dat"))){
			oos.writeObject(people);
			oos.flush();
		} catch (IOException e) {
			System.out.println("[SYSTEM] 파일 쓰기 실패");
		}
		people=null;
	}
}
