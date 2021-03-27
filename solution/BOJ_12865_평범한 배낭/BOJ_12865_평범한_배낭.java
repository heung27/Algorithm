import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12865_평범한_배낭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dp;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		dp = new int[K+1];
		
		for (int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			int W = Integer.parseInt(str[0]);
			int V = Integer.parseInt(str[1]);
			
			for (int j=K; j-W>=0; j--) {
				dp[j] = Math.max(dp[j], dp[j-W] + V);
			}
		}
		
		System.out.println(dp[K]);
	}
}
