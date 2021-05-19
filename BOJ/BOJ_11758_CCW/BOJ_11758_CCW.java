import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11758_CCW {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int x1, y1, x2, y2, x3, y3;
		String[] str = null;
		
		str = br.readLine().split(" ");
		x1 = Integer.parseInt(str[0]);
		y1 = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		x2 = Integer.parseInt(str[0]);
		y2 = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		x3 = Integer.parseInt(str[0]);
		y3 = Integer.parseInt(str[1]);
		
		System.out.println(CrossProduct(x1, y1, x2, y2, x3, y3));
	}
	
	static int CrossProduct(int x1, int y1, int x2, int y2, int x3, int y3) {
		int CrossProduct = (x1*y2 - x2*y1) + (x2*y3 - x3*y2) + (x3*y1 - x1*y3);
		
		if (CrossProduct < 0) return -1;
		else if (CrossProduct > 0) return 1;
		else return 0;
	}
}
