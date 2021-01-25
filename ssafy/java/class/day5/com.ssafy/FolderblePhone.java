package com.ssafy;

public class FolderblePhone extends Phone {
	private int width;
	private int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSmallSize() {
		return (this.width/2) * this.height;
	}

	public int getLargeSize() {
		return this.width * this.height;
	}
}
