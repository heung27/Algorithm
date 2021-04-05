import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_4485_녹색_옷_입은_애가_젤다지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static class Node implements Comparable<Node> {
		int x, y;
		int weight;
		
		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map;
	static boolean[][] check;
	static int N, T = 1;
	
	public static void main(String[] args) throws IOException {
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			map = new int[N][N];
			check = new boolean[N][N];
			
			for (int i=0; i<N; i++) {
				String[] str = br.readLine().split(" ");
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			sb.append("Problem ").append(T++).append(": ");
			sb.append(Dijstra(0, 0)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int Dijstra(int x, int y) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(x, y, map[x][y]));
		check[x][y] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.x == N-1 && node.y == N-1) return node.weight;
			
			for (int d=0; d<4; d++) {
				int nx = node.x + movex[d];
				int ny = node.y + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if (!check[nx][ny]) {
					queue.offer(new Node(nx, ny, node.weight+map[nx][ny]));
					check[nx][ny] = true;
				}
			}
		}
		return 0;
	}
}
