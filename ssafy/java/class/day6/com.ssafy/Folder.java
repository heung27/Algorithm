package com.ssafy;

public interface Folder {
	public void fold();
	public void open();
	
	default public void powerOn() {
		System.out.println("Power On!");
	}
}
