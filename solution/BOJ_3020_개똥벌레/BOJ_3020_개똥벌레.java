import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] up, down;
	static int N, H;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		H = Integer.parseInt(str[1]);
		down = new int[H];
		up = new int[H];
		
		for (int i=0; i<N/2; i++) {
			int d = Integer.parseInt(br.readLine());
			down[d]++;
			
			int u = Integer.parseInt(br.readLine());
			up[u]++;
		}
		
		for (int i=H-1; i>1; i--) {
			down[i-1] += down[i];
			up[i-1] += up[i];
		}
		
		int[] answer = new int[H];
		for (int j=1; j<H; j++) {
			answer[j-1] += down[j];
		}
		for (int j=1; j<H; j++) {
			answer[H-j] += up[j];
		}
		
		int min = Integer.MAX_VALUE, cnt = 0;
		for (int i=0; i<H; i++) {
			if (min == answer[i]) cnt++;
			else if (min > answer[i]) {
				min = answer[i];
				cnt = 1;
			}
		}
		
		sb.append(min).append(" ").append(cnt);
		System.out.println(sb);
	}
}
