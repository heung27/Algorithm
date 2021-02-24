package com.ssafy.happyhouse.model.dto;

public class StoreMapInfo {
	private String number; // 상가번호
	
	private String Sname; // 상호명
	
	private String address; // 주소
	
	public StoreMapInfo(String number, String sname, String address) {
		super();
		this.number = number;
		this.Sname = sname;
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StoreMapInfo [number=" + number + ", Sname=" + Sname + ", address=" + address + "]";
	}
}
