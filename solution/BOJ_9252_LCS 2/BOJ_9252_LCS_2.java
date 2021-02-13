import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9252_LCS_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dp;
	static String str1, str2;
	
	public static void main(String[] args) throws IOException {
		str1 = br.readLine();
		str2 = br.readLine();
		
		dp = new int[str1.length()+1][str2.length()+1];
		
		for (int i=1; i<=str1.length(); i++) {
			for (int j=1; j<=str2.length(); j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int answer = dp[str1.length()][str2.length()];
		
		System.out.println(answer);
		if (answer > 0) {
			int temp = answer, j = str2.length();
			for (int i=str1.length(); i>0; i--) {
				if (temp > dp[i-1][j]) {
					while (temp == dp[i][j-1]) j--;
					sb.append(str1.charAt(i-1));
					j--;
					temp = dp[i][j];
				}
			}
		}
		sb.reverse();
		System.out.println(sb);
	}
}
