import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_19238_스타트_택시 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map;
	static Point[] end;
	static boolean[][] check;
	static int N, M, K;
	static int X, Y, num, answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		map = new int[N+1][N+1];
		check = new boolean[N+1][N+1];
		end = new Point[M+2];
		
		for (int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			for (int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		str = br.readLine().split(" ");
		X = Integer.parseInt(str[0]);
		Y = Integer.parseInt(str[1]);
		
		int num = 2;
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			
			map[x1][y1] = num;
			end[num++] = new Point(x2, y2);
		}
		
		while (M-- > 0) {
			if (!BFS()) {
				K = -1;
				break;
			}
			if (!run()) {
				K = -1;
				break;
			}
		}
		System.out.println(K);
	}
	
	static boolean BFS() {
		init();
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(X, Y));
		check[X][Y] = true;
		int move = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				Point pos = queue.poll();
				
				if (map[pos.x][pos.y] > 1){
					if (move > K) return false;
					K -= move;
					X = pos.x;
					Y = pos.y;
					
					while (size-- > 0) {
						Point temp = queue.poll();
						if (map[temp.x][temp.y] > 1){
							if (temp.x < X || (temp.x == X && temp.y < Y)) {
								X = temp.x;
								Y = temp.y;
							}
						}
					}
					num = map[X][Y];
					map[X][Y] = 0;
					return true;
				}
				
				for (int d=0; d<4; d++) {
					int nx = pos.x + movex[d];
					int ny = pos.y + movey[d];
					
					if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] == 1) continue;
					
					if (!check[nx][ny]) {
						queue.offer(new Point(nx, ny));
						check[nx][ny] = true;
					}
				}
			}
			move++;
		}
		return false;
	}
	
	static boolean run() {
		init();
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(X, Y));
		check[X][Y] = true;
		
		int move = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				Point pos = queue.poll();
				
				if (pos.x == end[num].x && pos.y == end[num].y){
					if (move > K) return false;
					
					X = pos.x;
					Y = pos.y;
					K += move;
					return true;
				}
				
				for (int d=0; d<4; d++) {
					int nx = pos.x + movex[d];
					int ny = pos.y + movey[d];
					
					if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] == 1) continue;
					
					if (!check[nx][ny]) {
						queue.offer(new Point(nx, ny));
						check[nx][ny] = true;
					}
				}
			}
			move++;
		}
		return false;
	}
	
	static void init() {
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				check[i][j] = false;
			}
		}
	}
}
