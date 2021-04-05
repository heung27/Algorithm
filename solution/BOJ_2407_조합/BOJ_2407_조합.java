import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ_2407_조합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static BigInteger[][] dp;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		dp = new BigInteger[101][101];
		dp[1][1] = new BigInteger("1");
		
		for (int i=1; i<N; i++) {
			dp[i][0] = new BigInteger("1");
			dp[i][i] = new BigInteger("1");
		}
		
		for (int i=2; i<=N; i++) {
			for (int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		
		System.out.println(dp[N][M]);
	}
}
