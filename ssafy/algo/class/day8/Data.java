
public class Data {
	int x, y;
	int cnt;
	
	public Data(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Data [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
	}
}
