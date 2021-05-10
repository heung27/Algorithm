import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8895_막대_배치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static long[][][] dp;
	static int N, L, R;
	
	public static void main(String[] args) throws IOException {
		dp = new long[21][21][21];
		dp[1][1][1] = 1;
		
		for (int i=2; i<=20; i++) {
			for (int j=1; j<=20; j++) {
				for (int k=1; k<=20; k++) {
					dp[i][j][k] = dp[i-1][j-1][k] + dp[i-1][j][k-1] + (i-2) * dp[i-1][j][k];
				}
			}
		}
		
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			L = Integer.parseInt(str[1]);
			R = Integer.parseInt(str[2]);
			
			sb.append(dp[N][L][R]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
