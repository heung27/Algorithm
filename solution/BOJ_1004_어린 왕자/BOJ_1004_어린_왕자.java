import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1004_어린_왕자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int x1, y1, x2, y2;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		
		while (test-- > 0) {
			String[] str = br.readLine().split(" ");
			x1 = Integer.parseInt(str[0]);
			y1 = Integer.parseInt(str[1]);
			x2 = Integer.parseInt(str[2]);
			y2 = Integer.parseInt(str[3]);
			
			int n = Integer.parseInt(br.readLine());
			int x, y, r;
			
			cnt = 0;
			while (n-- > 0) {
				str = br.readLine().split(" ");
				x = Integer.parseInt(str[0]);
				y = Integer.parseInt(str[1]);
				r = Integer.parseInt(str[2]);
				
				boolean t = false;
				
				if (dist(x, y, x1, y1) < r) t = true;
				if (dist(x, y, x2, y2) < r) {
					if (t) t = false;
					else t = true;
				}
				
				if (t) cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
	
	static double dist(int x1, int y1, int x2, int y2) {
		int a = Math.abs(x1 - x2);
		int b = Math.abs(y1 - y2);
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
}
