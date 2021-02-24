package com.ssafy.happyhouse.model.dto;

public class EnviromentMapInfo {
	private int no;
	
	private String Sname; // 시설명
	
	private String Uname; // 업종명
	
	private String data; // 점검일자
	
	private String gubun; // 점검구분
	
	private String memo; // 점검사항
	
	private String address; // 주소
	
	public EnviromentMapInfo(int no, String sname, String uname, String data, String gubun, String memo,
			String address) {
		super();
		this.no = no;
		this.Sname = sname;
		this.Uname = uname;
		this.data = data;
		this.gubun = gubun;
		this.memo = memo;
		this.address = address;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "EnviromentMapInfo [Sname=" + Sname + ", Uname=" + Uname + ", data=" + data + ", gubun=" + gubun
				+ ", memo=" + memo + ", address=" + address + "]";
	}
}
