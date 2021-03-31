import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9251_LCS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static char[] s1, s2;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		s1 = br.readLine().toCharArray();
		s2 = br.readLine().toCharArray();
		
		dp = new int[s1.length+1][s2.length+1];
		
		for (int i=1; i<=s1.length; i++) {
			for (int j=1; j<=s2.length; j++) {
				if (s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[s1.length][s2.length]);
	}
}
