import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수_찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] list;
	static int N, M;
	static int data;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			data = Integer.parseInt(st.nextToken());
			search(0, N-1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void search(int L, int R) { // 이분 탐색 연습
		int left = L, right = R;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list[mid] == data) {
				sb.append(1);
				return;
			}
			else if (list[mid] < data) left = mid+1;
			else right = mid-1;
		}
		sb.append(0);
	}
}
