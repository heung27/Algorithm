import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static Queue<int[]> queue_zero = new LinkedList<>();
	static Queue<int[]> queue_one = new LinkedList<>();
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map;
	static boolean[][] check;
	static int N, M;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[1]);
		M = Integer.parseInt(str[0]);
		map = new int[N][M];
		check = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		queue_zero.offer(new int[] {0, 0});
		check[0][0] = true;
		while (!BFS_zero() && !BFS_one()) {};
		
		System.out.println(answer);
	}
	
	static boolean BFS_zero() {
		while (!queue_zero.isEmpty()) {
			int[] pos = queue_zero.poll();
			
			if (pos[0] == N-1 && pos[1] == M-1) return true;
			
			for (int i=0; i<4; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if (!check[nx][ny]) {
					if (map[nx][ny] == 0) {
						queue_zero.offer(new int[] {nx, ny});
					}
					else {
						queue_one.offer(new int[] {nx, ny});
					}
					check[nx][ny] = true;
				}
			}
		}
		answer++;
		return false;
	}
	
	static boolean BFS_one() {
		int size = queue_one.size();
		while (size-- > 0) {
			int[] pos = queue_one.poll();
			
			if (pos[0] == N-1 && pos[1] == M-1) return true;
			
			for (int i=0; i<4; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if (!check[nx][ny]) {
					if (map[nx][ny] == 0) {
						queue_zero.offer(new int[] {nx, ny});
					}
					else {
						queue_one.offer(new int[] {nx, ny});
					}
					check[nx][ny] = true;
				}
			}
		}
		return false;
	}
}
