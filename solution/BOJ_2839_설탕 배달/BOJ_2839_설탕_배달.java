import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2839_설탕_배달 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N+3];
		dp[3] = dp[5] = 1;
		
		for (int i=6; i<N+1; i++) {
			if (dp[i-3] != 0) {
				dp[i] = dp[i-3] + 1;
			}
			if (dp[i-5] != 0) {
				dp[i] = dp[i-5] + 1;
			}
		}
		if (dp[N] == 0) System.out.println(-1);
		else System.out.println(dp[N]);
	}
}
