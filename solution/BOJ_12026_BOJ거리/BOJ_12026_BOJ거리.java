import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12026_BOJ거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dp;
	static char[] str;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		str = br.readLine().toCharArray();
		
		dp = new int[N];
		dp[0] = 0;
		for (int i=1; i<N; i++) {
			if (str[i] == 'B') {
				dp[i] = searchMin(i, 'J');
			}
			else if (str[i] == 'J') {
				dp[i] = searchMin(i, 'O');
			}
			else {
				dp[i] = searchMin(i, 'B');
			}
		}
		
		if (dp[N-1] == Integer.MAX_VALUE) dp[N-1] = -1;
		System.out.println(dp[N-1]);
	}
	
	static int searchMin(int i, char c) {
		int min = Integer.MAX_VALUE;
		for (int cnt=1; cnt<=i; cnt++) {
			if (str[i-cnt] == c && dp[i-cnt] != Integer.MAX_VALUE) {
				min = Math.min(min, dp[i-cnt] + (cnt * cnt));
			}
		}
		return min;
	}
}
