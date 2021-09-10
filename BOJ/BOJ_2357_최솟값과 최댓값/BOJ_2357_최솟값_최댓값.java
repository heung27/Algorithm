import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2357_최솟값_최댓값 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int size = 1;
		while (size < N) {
			size <<= 1;
		}
		
		int[] max_tree = new int[size<<1+1];
		int[] min_tree = new int[size<<1+1];
		Arrays.fill(min_tree, Integer.MAX_VALUE);
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			max_tree[size+i] = num;
			min_tree[size+i] = num;
		}
		
		int temp = size;
		while (temp > 1) {
			for (int i=0; i<temp; i+=2) {
				max_tree[(temp+i)/2] = Math.max(max_tree[temp+i], max_tree[temp+i+1]);
			}
			for (int i=0; i<temp; i+=2) {
				min_tree[(temp+i)/2] = Math.min(min_tree[temp+i], min_tree[temp+i+1]);
			}
			temp >>= 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(getMin(min_tree, size+a-1, size+b-1));
			sb.append(" ");
			sb.append(getMax(max_tree, size+a-1, size+b-1));
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int getMax(int[] tree, int left, int right) {
		int max = 0;
		while (left <= right) {
			if (left % 2 == 1) {
				max = Math.max(max, tree[left++]);
			}
			if (right % 2 == 0) {
				max = Math.max(max, tree[right--]);
			}
			left >>= 1;
			right >>= 1;
		}
		return max;
	}
	
	static int getMin(int[] tree, int left, int right) {
		int min = Integer.MAX_VALUE;
		while (left <= right) {
			if (left % 2 == 1) {
				min = Math.min(min, tree[left++]);
			}
			if (right % 2 == 0) {
				min = Math.min(min, tree[right--]);
			}
			left >>= 1;
			right >>= 1;
		}
		return min;
	}
}
