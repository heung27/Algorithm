import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11726_2xN_타일링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		dp[0] = 1;
		if (N > 1) dp[1] = 2;
		
		for (int i=2; i<N; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[N-1]);
	}
}
