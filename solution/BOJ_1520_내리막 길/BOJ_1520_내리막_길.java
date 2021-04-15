import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1520_내리막_길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map, dp;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		BFS();
		
		System.out.println(dp[N-1][M-1]);
	}
	
	static void BFS() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return map[o2[0]][o2[1]] - map[o1[0]][o1[1]];
			}
		});
		queue.offer(new int[] {0, 0});
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			if (pos[0] == N-1 && pos[1] == M-1) break;
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if (map[pos[0]][pos[1]] > map[nx][ny]) {
					if (dp[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
					}
					dp[nx][ny] += dp[pos[0]][pos[1]];
				}
			}
		}
	}
}
