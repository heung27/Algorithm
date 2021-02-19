import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2240_자두나무 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][][] dp;
	static int T, W;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		T = Integer.parseInt(str[0]);
		W = Integer.parseInt(str[1]);
		
		dp = new int[2][T+1][W+2];
		
		for (int i=1; i<=T; i++) {
			int t = Integer.parseInt(br.readLine());
			for (int j=1; j<=W+1; j++) { // j-1 : 움직인 횟수
				if (t == 1) { // 자두가 첫 번째 나무에서 떨어질 때
					
					// 자두를 받는 경우. 1초 전에 1의 자리에 있으면 w에서  cnt+1 or 2의 자리에 있으면 w-1에서  cnt+1
					dp[0][i][j] = Math.max(dp[0][i-1][j]+1, dp[1][i-1][j-1]+1);
					
					// 자두를 받지 않는 경우. 1초 전에 1의 자리에 있으면 w-1에서  cnt or 2의 자리에 있으면 w에서  cnt
					dp[1][i][j] = Math.max(dp[0][i-1][j-1], dp[1][i-1][j]);
				}
				else { // 자두가 두 번째 나무에서 떨어질 때
					
					// j-1는 움직인 횟수. 처음에 움직이지 않고 두 번째 나무의 자두를 받을 수 없기 때문에 continue.
					if (i == 1 && j == 1) continue; 
					
					// 자두를 받지 않는 경우. 1초 전에 1의 자리에 있으면 w에서  cnt or 2의 자리에 있으면 w-1에서  cnt
					dp[0][i][j] = Math.max(dp[0][i-1][j], dp[1][i-1][j-1]);
					
					// 자두를 받는 경우. 1초 전에 1의 자리에 있으면 w-1에서  cnt+1 or 2의 자리에 있으면 w에서  cnt+1
					dp[1][i][j] = Math.max(dp[0][i-1][j-1]+1, dp[1][i-1][j]+1);
				}
			}
		}
		int max = 0;
		for (int i=1; i<=W+1; i++) {
			max = Math.max(max, Math.max(dp[0][T][i], dp[1][T][i]));
		}
		System.out.println(max);
	}
}
