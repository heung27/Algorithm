package lab.ssafy.corona.virus;

public class MedicineThread extends Thread {
	Cell cell;
	
	public MedicineThread(Cell cell) {
		this.cell = cell;
	}
	
	/*
	@Override
	public void run() {
		
		synchronized(cell) {
			if( cell.power < 500 ) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				cell.power = cell.power + 100;
			}
			
			System.out.println("MedicineThread : " + cell.power);
		}
	}
	*/
	
	@Override
	public void run() {
		
		synchronized(cell) {
			if( cell.power >= 500 ) {
				try {
					cell.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if( cell.power < 500 ) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				cell.power = cell.power + 100;
				cell.notifyAll();
			}
	
			System.out.println("MedicineThread : " + cell.power);
		}
	}
}
