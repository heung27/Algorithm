import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1010_다리_놓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static long[][] dp = new long[31][31];
	static int T, N, M;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		dp[1][1] = 1;
		
		for (int i=1; i<30; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		for (int i=2; i<=30; i++) {
			for (int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		while (T-- > 0) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			sb.append(dp[M][N]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
