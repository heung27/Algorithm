package com.ssafy.day7;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerTest4 {
	ActionListener mysave = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	public InnerTest4() {
		Button btn1 = new Button("파일 저장");
		Button btn2 = new Button("파일 삭제");
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("파일 저장");
			}
		});
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("파일 삭제");

			}
		});
	}
	public static void main(String[] args) {
		new InnerTest4();
	}
}
