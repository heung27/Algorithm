package com.ssafy.corona.medical;

public class Hospital extends Organization{
	private String hospitalId;
	private int roomTotalCount;
	private int roomEmptyCount;

	public Hospital() {}
	public Hospital(String name, int employeeCount, String hospitalId, int roomTotalCount, int roomEmptyCount) {
		super(name, employeeCount);
		setHospitalId(hospitalId);
		setRoomTotalCount(roomTotalCount);
		setRoomEmptyCount(roomEmptyCount);
	}
	
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getRoomTotalCount() {
		return roomTotalCount;
	}
	public void setRoomTotalCount(int roomTotalCount) {
		this.roomTotalCount = roomTotalCount;
	}
	public int getRoomEmptyCount() {
		return roomEmptyCount;
	}
	public void setRoomEmptyCount(int roomEmptyCount) {
		this.roomEmptyCount = roomEmptyCount;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getHospitalId()).append("\t")
		  .append(getRoomTotalCount()).append("\t")
		  .append(getRoomEmptyCount());
		return sb.toString();
	}
}
