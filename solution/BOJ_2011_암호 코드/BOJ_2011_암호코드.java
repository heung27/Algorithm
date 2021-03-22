import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2011_암호코드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] dp;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		String num = br.readLine();
		
		int size = num.length();
		dp = new int[2][size];
		arr = new int[size];
		
		for (int i=0; i<size; i++) {
			arr[i] = num.charAt(i)-48;
		}
		
		dp[0][size-1] = 1;
		
		int i = size-2;
		for ( ; i>=0; i--) {
			if (arr[i+1] != 0) {
				dp[0][i] = (dp[0][i+1] + dp[1][i+1]) % 1000000;
			}
			
			if (arr[i] != 0 && arr[i] * 10 + arr[i+1] <= 26) {
				dp[1][i] = dp[0][i+1];
			}
			
			if (dp[0][i] == 0 && dp[1][i] == 0) break;
		}
		
		int answer = 0;
		if (arr[0] != 0 && i < 0) answer = (dp[0][0] + dp[1][0]) % 1000000;
		
		System.out.println(answer);
	}
}
