import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁_전투 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	static boolean[][] check;
	static char[][] map;
	static int N, M;
	static int W, B;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[M][N];
		check = new boolean[M][N];
		
		for (int i=0; i<M; i++) {
			String s = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (!check[i][j]) BFS(i, j);
			}
		}
		System.out.println(W+" "+B);
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		check[x][y] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			cnt ++;
			
			for (int i=0; i<4; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				
				if (!check[nx][ny] && map[x][y] == map[nx][ny]) {
					queue.offer(new int[] {nx, ny});
					check[nx][ny] = true;
				}
			}
		}
		
		if (map[x][y] == 'W') W += Math.pow(cnt, 2);
		else B += Math.pow(cnt, 2);
	}
}
