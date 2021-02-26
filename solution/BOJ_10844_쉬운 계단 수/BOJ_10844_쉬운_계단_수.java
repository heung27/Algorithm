import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10844_쉬운_계단_수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dp;
	static int N, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][11];
		
		for (int j=0; j<10; j++) {
			dp[1][j] = 1;
		}
		
		for (int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][1];
			for (int j=1; j<10; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
		}
		
		for (int j=1; j<10; j++) {
			answer = (answer + dp[N][j]) % 1000000000;
		}
		
		System.out.println(answer);
	}
}
