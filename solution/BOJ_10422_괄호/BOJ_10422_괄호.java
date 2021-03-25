import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10422_괄호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static long[] DP = new long[5001];
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		DP[0] = 1;
		DP[2] = 1;
		for (int i=4; i<=5000; i+=2) {
			for (int j=0; j<=i-2; j+=2) {
				DP[i] += (DP[j] * DP[i-j-2]) % 1000000007;
				DP[i] %= 1000000007;
			}
		}
		
		while (test-- > 0) {
			int len = Integer.parseInt(br.readLine());
			sb.append(DP[len]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
