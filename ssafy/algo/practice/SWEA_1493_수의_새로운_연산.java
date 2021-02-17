import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1493_수의_새로운_연산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			int p1[] = trans(x);
			int p2[] = trans(y);
			
			int pos[] = {p1[0] + p2[0], p1[1] + p2[1]};
			
			int answer = 0;
			for (int i=1; i<=pos[0]; i++) {
				answer += i;
			}
			for (int i=1; i<pos[1]; i++) {
				answer += pos[0]++;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	static int[] trans(int num) {
		int x = 1, y = 1;
		
		int temp = 1, add = 2;
		if (temp != num)  {
			while (true) {
				temp += add;
				if (num <= temp) {
					int diff = temp - num;
					x = add - diff;
					y += diff;
					break;
				}
				add++;
			}
		}
		return new int[] {x, y};
	}
}
