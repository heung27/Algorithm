import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1915_가장_큰_정사각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map;
	static int[][] dp;
	static int N, M, answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		answer = -1;
		
		for (int i=1; i<=N; i++) {
			String s = br.readLine();
			for (int j=1; j<=M; j++) {
				map[i][j] = s.charAt(j-1)-'0';
				
				if (map[i][j] == 1) {
					if (answer == -1) answer = 0;
					
					if (map[i-1][j] == 1 && map[i][j-1] == 1 && map[i-1][j-1] == 1) {
						int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
						dp[i][j] = min + 1;
						if (answer < dp[i][j]) answer = dp[i][j];
					}
				}
			}
		}
		answer++;
		System.out.println(answer * answer);
	}
}
