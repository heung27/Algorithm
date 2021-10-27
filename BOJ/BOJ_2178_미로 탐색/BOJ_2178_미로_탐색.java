import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178_미로_탐색 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean[][] visit;
	static int[][] map;
	static int N, M;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		visit = new boolean[N][M];
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String temp = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		System.out.println(BFS());
	}
	
	public static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				
				if (pos[0] == N-1 && pos[1] == M-1) return cnt;
				
				for (int d=0; d<4; d++) {
					int nx = pos[0] + movex[d];
					int ny = pos[1] + movey[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny]) continue;
					
					if (map[nx][ny] == 1) {
						visit[nx][ny] = true;
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
		return cnt;
	}
}
