package com.ssafy.hw07;

public interface IProductMgr {
	public void add(Product P);
	
	public void list();
	
	public void list(int num);
	
	public void list(String name);
	
	public void listTV();
	
	public void listRef();
	
	public void overCapacity();
	
	public void overInch();
	
	public void update(int number, int price);
	
	public void delete(int num);
	
	public void totalPrice();
}
