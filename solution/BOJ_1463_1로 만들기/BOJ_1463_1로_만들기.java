import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1463_1로_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp[1] = 0;
		
		for (int i=2; i<=N; i++) {
			if (i % 6 == 0) dp[i] = Math.min(dp[i-1], Math.min(dp[i/2], dp[i/3])) + 1;
			else if (i % 2 == 0) dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
			else if (i % 3 == 0) dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
			else dp[i] = dp[i-1] + 1;
		}
		
		System.out.println(dp[N]);
	}
}
