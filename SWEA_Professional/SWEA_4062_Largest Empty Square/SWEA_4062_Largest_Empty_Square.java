import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4062_Largest_Empty_Square {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N+1][N+1];
			int[][] dp = new int[N+1][N+1];
			int len = 0;
			
			for (int i=1; i<=N; i++) {
				String s = br.readLine();
				for (int j=1; j<=N; j++) {
					map[i][j] = s.charAt(j-1)-47;
					
					if (map[i][j] == 1) {
						if (map[i-1][j] == 1 && map[i][j-1] == 1 && map[i-1][j-1] == 1) {
							int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
							dp[i][j] = min + 1;
							
							len = Math.max(len, dp[i][j]);
						}
					}
				}
			}
			len++;
			sb.append("#").append(t).append(" ").append(len).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
