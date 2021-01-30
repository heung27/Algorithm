package com.ssafy.hw08;

public interface IProductMgr {
	public void add(Product P) throws DuplicateException;
	
	public void list();
	
	public void list(int num) throws CodeNotFoundException;
	
	public void list(String name);
	
	public void listTV();
	
	public void listRef();
	
	public void overCapacity() throws ProductNotFoundException;
	
	public void overInch() throws ProductNotFoundException;
	
	public void update(int number, int price);
	
	public void delete(int num);
	
	public void totalPrice();
}
