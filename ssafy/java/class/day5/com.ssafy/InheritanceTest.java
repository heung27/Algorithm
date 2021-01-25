package com.ssafy;

public class InheritanceTest {
	public static void main(String[] args) {
		FolderblePhone fPhone = new FolderblePhone();
		
		fPhone.setName("Galaxy Folder2");
		fPhone.setColor('B');
		fPhone.setPrice(20000);

		System.out.println( fPhone );
		System.out.println( fPhone.getSalePrice() );
		
		fPhone.setWidth(500);
		fPhone.setHeight(1000);

		System.out.println( fPhone.getSmallSize() );
		System.out.println( fPhone.getLargeSize() );
	}
}
