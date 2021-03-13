import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4991_로봇_청소기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static char[][] map = new char[20][20];
	static boolean[][] check = new boolean[20][20];
	
	static Pos[] pos = new Pos[11];
	static int[][] distance;
	
	static boolean[] number;
	static int R, C;
	static int answer, cnt;
	
	public static void main(String[] args) throws IOException {
		while (true) {
			String[] str = br.readLine().split(" ");
			C = Integer.parseInt(str[0]);
			R = Integer.parseInt(str[1]);
			
			if (R == 0 && C == 0) break;
			
			cnt = 1;
			answer = Integer.MAX_VALUE;
			
			for (int i=0; i<R; i++) {
				String s = br.readLine();
				for (int j=0; j<C; j++) {
					map[i][j] = s.charAt(j);
					
					if (map[i][j] == 'o') {
						pos[0] = new Pos(i, j);
					}
					if (map[i][j] == '*') {
						pos[cnt++] = new Pos(i, j);
					}
				}
			}
			distance = new int[cnt][cnt];
			number = new boolean[cnt];
			
			if (!isCheck()) sb.append("-1");
			else {
				DFS(0, 0, 0);
				sb.append(answer);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean isCheck() {
		for (int i=0; i<cnt; i++) {
			for (int j=i+1; j<cnt; j++) {
				reset();
				if (!BFS(pos[i], pos[j], i, j)) return false;
			}
		}
		return true;
	}
	
	static boolean BFS(Pos start, Pos end, int num1, int num2) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(start);
		check[start.x][start.y] = true;
		int move = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			move++;
			
			while (size-- > 0) {
				Pos next = queue.poll();
				
				for (int i=0; i<4; i++) {
					int nx = next.x + movex[i];
					int ny = next.y + movey[i];
					
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'x' || check[nx][ny]) continue;
					
					if (nx == end.x && ny == end.y) {
						distance[num1][num2] = move;
						distance[num2][num1] = move;
						return true;
					}
					
					queue.offer(new Pos(nx, ny));
					check[nx][ny] = true;
				}
			}
		}
		return false;
	}
	
	static void reset() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				check[i][j] = false;
			}
		}
	}
	
	static void DFS(int depth, int start, int sum) {
		if (depth == cnt-1) {
			answer = Math.min(answer, sum);
			return;
		}
		for (int i=1; i<cnt; i++) {
			if (!number[i]) {
				number[i] = true;
				DFS(depth+1, i, sum+distance[start][i]);
				number[i] = false;
			}
		}
	}
}
