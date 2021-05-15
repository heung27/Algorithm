import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static class Point implements Comparable<Point> {
		int x, y;
		int sum;
		
		public Point(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.sum - o.sum;
		}
	}
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, -1, 0, 1};
	
	static boolean[][] check;
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			
			for (int i=0; i<N; i++) {
				String s = br.readLine();
				for (int j=0; j<N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			sb.append("#").append(t).append(" ").append(BFS()).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int BFS() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(0, 0, map[0][0]));
		check[0][0] = true;
		
		while (!queue.isEmpty()) {
			Point pos = queue.poll();
			
			if (pos.x == N-1 && pos.y == N-1) return pos.sum;
			
			for (int d=0; d<4; d++) {
				int nx = pos.x + movex[d];
				int ny = pos.y + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny]) continue;
				
				queue.offer(new Point(nx, ny, pos.sum + map[nx][ny]));
				check[nx][ny] = true;
			}
		}
		
		return -1;
	}
}
