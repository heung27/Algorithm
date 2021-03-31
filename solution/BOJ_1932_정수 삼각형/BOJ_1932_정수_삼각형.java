import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1932_정수_삼각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dp, temp;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			
			temp = new int[N+1];
			for (int j=1; j<=i; j++) {
				temp[j] = Math.max(dp[j-1], dp[j]) + Integer.parseInt(str[j-1]);
			}
			dp = temp;
		}
		
		for (int i=1; i<=N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}
