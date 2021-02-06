import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057_오르막_수 {
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1][10];
		int sum = 1;
		for (int i=1; i<=N; i++) {
			dp[i][0] = sum;
			for (int j=1; j<10; j++) {
				dp[i][j] = (dp[i][j-1] - dp[i-1][j-1] + 10007) % 10007;
				sum = (sum + dp[i][j]) % 10007;
			}
		}
		System.out.println(sum);
	}
}
