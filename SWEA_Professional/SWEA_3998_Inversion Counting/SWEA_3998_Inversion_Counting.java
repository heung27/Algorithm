import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3998_Inversion_Counting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] arr, temp;
	static int N;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			
			arr = new int[N+1];
			temp = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			merge_sort(1, N);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void merge_sort(int left, int right) {
		int mid = (left + right) / 2;
		
		if (left < right) {
			merge_sort(left, mid);
			merge_sort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int p = left;
		int q = mid+1;
		
		int index = left;
		
		while (p <= mid && q <= right) {
			if (arr[p] < arr[q]) {
				temp[index++] = arr[p++];
			}
			else {
				temp[index++] = arr[q++];
				answer += mid-p+1;
			}
		}
		
		while (p <= mid) temp[index++] = arr[p++];
		
		while (q <= right) temp[index++] = arr[q++];
		
		for (int i=left; i<=right; i++) {
			arr[i] = temp[i];
		}
	}
}
