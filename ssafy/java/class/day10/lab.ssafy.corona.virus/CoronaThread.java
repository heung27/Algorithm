package lab.ssafy.corona.virus;

public class CoronaThread extends Thread {
	int num;
	Cell cell;
	
	public CoronaThread(int num) {
		this.num = num;
	}
	
	public CoronaThread(Cell cell) {
		this.cell = cell;
	}
	
	/*
	@Override
	public void run() {
		
//		for( int i=0; i< 10000; i++ ) {
//			if( i == 5000 && num % 2 == 0 ) {
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(num);
		
		try{
			System.out.println("thread try start"); 
			Thread.sleep(5000);  
			System.out.println("thread try end");  
		}catch(InterruptedException e){
			System.out.println("thread interrupted raised"); 
		}
		System.out.println(num);
	}
	*/
	
	@Override
	public void run() {
		synchronized(cell) {
			if( cell.power < 100 ) {
				try {
					cell.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if( cell.power >= 100 ) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				cell.power = cell.power - 100;
				cell.notifyAll();
			}
		}
		System.out.println("CoronaThread : " + cell.power);
	}
}
