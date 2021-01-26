package lab.ssafy.corona.virus;

public class Corona extends Virus{
	public int spreadSpeed;

	public int getSpreadSpeed() {
		return spreadSpeed;
	}

	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}
	
	public void showInfo() {
		String info =  super.getName() + " " + super.getLevel() + " " + this.spreadSpeed;
		System.out.println(info);
	}
	
	public Corona() {}
	
	
	public Corona(String name, int level, int spreadSpeed ) {
		super(name, level);
		this.spreadSpeed = spreadSpeed;
	}
	
	public String toString() {
		return super.getName() + " " + super.getLevel() + " " + this.spreadSpeed;
	}
}
