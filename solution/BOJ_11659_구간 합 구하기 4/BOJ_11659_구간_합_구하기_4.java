import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11659_구간_합_구하기_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] num, dp;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		num = new int[N+1];
		dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<=N; i++) {
			dp[i] = dp[i-1] + num[i];
		}
		
		while (M-- > 0) {
			str = br.readLine().split(" ");
			sb.append(dp[Integer.parseInt(str[1])] - dp[Integer.parseInt(str[0])-1]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
