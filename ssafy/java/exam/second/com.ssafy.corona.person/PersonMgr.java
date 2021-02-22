package com.ssafy.corona.person;

import java.util.List;

public interface PersonMgr {
	void add(Person p);
	List<Person> search();
	Person search(String name);
	void delete(String name);
	void load();
	void save();
}