import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17142_연구소_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point[] virus = new Point[11];
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map;
	static boolean[][] check;
	static int[] number;
	static int N, M;
	static int cnt, cnt_0, answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][N];
		check = new boolean[N][N];
		number = new int[M];
		answer = Integer.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 2) virus[cnt++] = new Point(i, j);
				else if (map[i][j] == 0) cnt_0++;
			}
		}
		
		if (cnt_0 == 0) System.out.println(0);
		else {
			combination(0, 0);
			if (answer == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(answer);
		}
	}
	
	static void combination(int depth, int start) {
		if (depth == M) {
			init();
			BFS();
			return;
		}
		for (int i=start; i<cnt; i++) {
			number[depth] = i;
			combination(depth+1, i+1);
		}
	}
	
	static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		for (int i=0; i<M; i++) {
			Point v = virus[number[i]];
			queue.offer(v);
			check[v.x][v.y] = true;
		}
		int time = 0, spread = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			time++;
			while (size-- > 0) {
				Point p = queue.poll();
				
				for (int i=0; i<4; i++) {
					int nx = p.x + movex[i];
					int ny = p.y + movey[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					if (!check[nx][ny] && map[nx][ny] != 1) {
						queue.offer(new Point(nx, ny));
						check[nx][ny] = true;
						
						if (map[nx][ny] == 0 && ++spread == cnt_0) {
							if (answer > time) answer = time;
							return;
						}
					}
				}
			}
		}
	}
	
	static void init() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				check[i][j] = false;
			}
		}
	}
}
