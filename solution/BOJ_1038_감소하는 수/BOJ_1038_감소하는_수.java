import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1038_감소하는_수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dp;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[10][10];
		
		if (N < 10) {
			System.out.println(N);
			return;
		}
		
		for (int j=0; j<10; j++) {
			dp[0][j] = 1;
		}
		
		int sum = 9;
		
		for (int i=1; i<10; i++) {
			for (int j=i; j<10; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
				sum += dp[i][j];
				
				if (sum >= N) {
					sb.append(j);
					
					int diff = sum - N + 1;
					int x = i-1;
					for (int y=j-1; y>=0; y--) {
						diff -= dp[x][y];
						if (diff <= 0) {
							diff += dp[x][y];
							sb.append(y);
							if (x == 0) break;
							x--;
						}
					}
					System.out.println(sb.toString());
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
