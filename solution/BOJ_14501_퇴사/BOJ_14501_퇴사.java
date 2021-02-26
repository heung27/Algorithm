import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] work;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		work = new int[N+1][2];
		dp = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			work[i][0] = Integer.parseInt(str[0]);
			work[i][1] = Integer.parseInt(str[1]);
		}
		
		for (int i=1; i<=N; i++) {
			if (work[i][0] + i > N+1) continue;
			int temp = 0;
			for (int j=1; j<i; j++) {
				if (work[i-j][0] <= j) {
					if (temp < dp[i-j]) temp = dp[i-j];
				}
			}
			dp[i] = temp + work[i][1];
		}
		
		int max = 0;
		for (int i=1; i<=N; i++) {
			if (max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);
	}
}
