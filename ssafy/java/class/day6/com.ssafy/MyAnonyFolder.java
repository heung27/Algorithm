package com.ssafy;

public class MyAnonyFolder implements Folder {
	@Override
	public void fold() {
		System.out.println("Anonymous-fold");
	}

	@Override
	public void open() {
		System.out.println("Anonymous-open");
	}
}
