package com.ssafy;

public class InstanceOfTest {
	public static void main(String[] args) {
		IOA ioc = new IOA();
		
//		if( ioc instanceof IOA ) {
//			System.out.println("IOA");
//		}else if( ioc instanceof IOB ) {
//			System.out.println("IOB");
//		}else if( ioc instanceof IOC ) {
//			System.out.println("IOC");
//		}
		
			if( ioc instanceof IOC ) {
				System.out.println("IOC");
			}else if( ioc instanceof IOB ) {
				System.out.println("IOB");
			}else if( ioc instanceof IOA ) {
				System.out.println("IOA");
			}
	}
}

class IOA{
	
}

class IOB extends IOA{
	
}

class IOC extends IOB{
	
}