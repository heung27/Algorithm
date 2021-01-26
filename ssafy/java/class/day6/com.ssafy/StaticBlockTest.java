package com.ssafy;

public class StaticBlockTest {
	public static void main(String[] args) {
		// 한 라인씩 수행
		StaticBlock sb;
		StaticBlock sb2 = new StaticBlock(); // static 한번만 실행
		StaticBlock sb3 = new StaticBlock(); 
		System.out.println(StaticBlock.MAX_SIZE);
	}
}
