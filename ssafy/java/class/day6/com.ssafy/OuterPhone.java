package com.ssafy;

public class OuterPhone {
	InnerChip ic;
	
	class InnerChip{
		String serialNo;
	}
	
	public OuterPhone(String serialNo) {
		ic = new InnerChip();
		ic.serialNo = serialNo;
	}
	public OuterPhone() {
		ic = new InnerChip();
	}
}
