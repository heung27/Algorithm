import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14505_팰린드롬_개수_구하기_small {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static char[] arr;
	static int[][] dp;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		N = str.length();
		
		arr = new char[N+1];
		dp = new int[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = str.charAt(i-1);
		}
		
		for (int i=1; i<=N; i++) {
			dp[i][i] = 1;
		}
		
		for (int i=1; i<N; i++) {
			if (arr[i] == arr[i+1]) {
				dp[i][i+1] = 3;
			}
			else {
				dp[i][i+1] = 2;
			}
		}
		
		for (int len=2; len<N; len++) {
			for (int i=1; i<=N-len; i++) {
				if (arr[i] == arr[i+len]) {
					dp[i][i+len] = dp[i+1][i+len] + dp[i][i+len-1] + 1;
				}
				else {
					dp[i][i+len] = dp[i+1][i+len] + dp[i][i+len-1] - dp[i+1][i+len-1];
				}
			}
		}
		
		System.out.println(dp[1][N]);
	}
}
