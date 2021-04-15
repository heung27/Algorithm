import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2565_전깃줄 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Edge implements Comparable<Edge> {
		int left, right;

		public Edge(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Edge o) {
			return this.left - o.left;
		}
	}
	
	static Edge[] map;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		map = new Edge[N];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			int left = Integer.parseInt(str[0]);
			int right = Integer.parseInt(str[1]);
			
			map[i] = new Edge(left, right);
		}
		
		Arrays.sort(map);
		
		dp[0] = map[0].right;
		int size = 0;
		for (int i=1; i<N; i++) {
			if (dp[size] < map[i].right) dp[++size] = map[i].right;
			else {
				int index = search(map[i].right, 0, size);
				dp[index] = map[i].right;
			}
		}
		System.out.println(N-size-1);
	}
	
	static int search(int num, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (dp[mid] >= num) right = mid;
			else left = mid + 1;
		}
		return right;
	}
}
