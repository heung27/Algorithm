import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17069_파이프_옮기기_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static long[][][] dp;
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N][3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k=1; k<N; k++) {
			if (map[0][k] == 1) break;
			dp[0][k][0] = 1;
		}
		
		for (int i=1; i<N; i++) {
			for (int j=2; j<N; j++) {
				if (map[i][j] == 1) continue;
				
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				
				if (map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				
				dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		
		long sum = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
		System.out.println(sum);
	}
}
