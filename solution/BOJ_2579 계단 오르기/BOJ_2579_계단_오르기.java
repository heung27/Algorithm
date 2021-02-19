import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579_계단_오르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] stair;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		stair = new int[N+1];
		dp = new int[N+1];
		for (int i=1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = stair[1];
		if (N >= 2) {
			dp[2] = dp[1] + stair[2];
			if (N >= 3) {
				for (int i=3; i<=N; i++) {
					dp[i] = Math.max(dp[i-3]+stair[i-1], dp[i-2]) + stair[i];
				}
			}
		}
		System.out.println(dp[N]);
	}
}
