import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SWEA_3819_최대_부분_배열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in); // 테케가 잘못 작성되어 있어서 스캐너로 받음
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(sc.next());
		for (int t=1; t<=test; t++) {
			int N = Integer.parseInt(sc.next());
			
			int[] arr = new int[N];
			long[] dp = new long[N];
			
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(sc.next());
			}
			
			long answer = arr[0];
			dp[0] = arr[0];
			for (int i=1; i<N; i++) {
				dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
				answer = Math.max(answer, dp[i]);
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
