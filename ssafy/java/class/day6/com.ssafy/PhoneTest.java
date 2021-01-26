package com.ssafy;

public class PhoneTest {

	public static void main(String[] args) {
//		Folder f = new FolderblePhone();
//		
//		if( f instanceof Folder ){
//			System.out.println("instanceof Folder");
//		}
//		
//		if( f instanceof Object ){
//			System.out.println("instanceof Object");
//		}
//		
//		if( f instanceof Phone ){
//			System.out.println("instanceof Phone");
//		}
//		
//		Phone p = new Phone();
//		
//		if( p instanceof FolderblePhone ) {
//			System.out.println("instanceof FolderblePhone");
//		}
		
//		OuterPhone op = new OuterPhone("12345");
//		System.out.println(op.ic.serialNo);
		
//		AnonymousFolder af = new AnonymousFolder();
//		af.setFolder(new Folder() {
//
//			@Override
//			public void fold() {
//				System.out.println("Anonymous-fold");
//			}
//
//			@Override
//			public void open() {
//				System.out.println("Anonymous-open");
//			}
//
//		});
//
//		Folder anonymous = new MyAnonyFolder();
//		af.setFolder(anonymous);
//
//		af.getFolder().fold();
//		af.getFolder().open();
		
		System.out.println(OuterPhoneStatic.InnerChip.serialNo);
	}
}
