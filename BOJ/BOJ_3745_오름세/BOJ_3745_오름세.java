import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3745_오름세 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String input = "";
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input.trim());
			int[] arr = new int[N];
			int[] dp = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = arr[0];
			int size = 0;
			for (int i=0; i<N; i++) {
				if (dp[size] < arr[i]) dp[++size] = arr[i];
				else {
					int index = BinarySearch(dp, arr[i], 0, size);
					dp[index] = arr[i];
				}
			}
			sb.append(size+1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int BinarySearch(int[] dp, int num, int left, int right) {
		while (left < right) {
			int mid = (left + right) >> 1;
			
			if (dp[mid] >= num) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return right;
	}
}
