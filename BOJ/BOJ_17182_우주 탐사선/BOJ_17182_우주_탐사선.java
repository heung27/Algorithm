import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17182_우주_탐사선 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] map;
	static boolean[] visit;
	static int N, K, answer;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		map = new int[N][N];
		visit = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		visit[K] = true;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		floyd();
		DFS(1, K, 0);
		
		System.out.println(answer);
	}
	
	public static void floyd() {
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				if (k == i) continue;
				for (int j=0; j<N; j++) {
					if (k == j || i == j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}
	
	public static void DFS(int cnt, int n, int sum) {
		if (cnt == N) {
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				DFS(cnt+1, i, sum+map[n][i]);
				visit[i] = false;
			}
		}
	}
}
