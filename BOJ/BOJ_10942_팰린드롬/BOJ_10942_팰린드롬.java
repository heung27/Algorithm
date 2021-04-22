import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[][] dp;
	static int[] arr;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new boolean[N+1][N+1];
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		palindrome();
		
		M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(dp[s][e]?1:0).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void palindrome() {
		for (int i=1; i<=N; i++) { // 길이 1
			dp[i][i] = true;
		}
		
		for (int i=1; i<N; i++) { // 길이 2
			if (arr[i] == arr[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		for (int len=2; len<N; len++) { // 길이 3 이상
			for (int i=1; i<=N-len; i++) {
				if (arr[i] == arr[i+len] && dp[i+1][i+len-1]) {
					dp[i][i+len] = true;
				}
			}
		}
	}
}
