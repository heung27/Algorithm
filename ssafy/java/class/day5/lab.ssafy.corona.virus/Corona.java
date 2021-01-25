package lab.ssafy.corona.virus;

//import com.ssafy.FakeVirus;

// 자바는 다중 상속을 지원하지 않음 
// 다중 구현(Interface)은 지원
// 모든 생성자의 첫 번째 줄에는 super



public class Corona extends Virus {
	private int spreadSpeed;

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
	
//	자식 클래스의 기본 생성자는 부모 클래스의 생성자를 별도로 호출하지 않으면 부모 클래스의 기본 생성자를 자동으로 호출한다. 기본 생성자가 없으면 호출 x
	public Corona() {
		 super("", 0); // 얘 없으면 오류
	}
	
	public Corona(String name, int level, int spreadSpeed ) {
		super(name, level); // 내가 만든 생성자에서 super 필수
		this.spreadSpeed = spreadSpeed;
	}
}
