import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_8382_방향_전환 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		
		for (int t = 1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			
			int x = Math.abs(x2 - x1), y = Math.abs(y2 - y1);
			
			sb.append("#").append(t).append(" ");
			
			if (x == y) {
				sb.append(x * 2).append("\n");
				continue;
			}
			
			if (x < y) {
				int temp = x;
				x = y;
				y = temp;
			}
			
			int diff = x - y;
			if (diff % 2 == 0) sb.append(x * 2).append("\n");
			else sb.append(x * 2 - 1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
