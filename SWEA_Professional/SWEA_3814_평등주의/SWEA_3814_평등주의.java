import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3814_평등주의 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] arr, left, right;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			left  = new int[N];
			right = new int[N];
			arr = new int[N];
			
			int max = 0, min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
			}
			
			sb.append("#").append(t).append(" ").append(BinarySearch(0, max - min)).append("\n");
		}
		bw.write(sb.toString());;
		bw.flush();
	}
	
	static int BinarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (check(mid)) right = mid - 1;
			else left = mid + 1;
		}
		return left;
	}
	
	static boolean check(int x) {
		left[0] = arr[0];
		for (int i=1; i<N; i++) {
			left[i] = Math.min(arr[i], left[i-1] + x);
		}
		
		right[N-1] = arr[N-1];
		for (int i=N-2; i>=0; i--) {
			right[i] = Math.min(arr[i], right[i+1] + x);
		}
		
		int sum = 0;
		for (int i=0; i<N; i++) {
			sum += arr[i] - Math.min(left[i], right[i]);
		}
		
		if (sum > K) return false;
		else return true;
	}
}
