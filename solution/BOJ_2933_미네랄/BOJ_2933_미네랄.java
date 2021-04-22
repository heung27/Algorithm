import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2933_미네랄 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static Queue<int[]> queue = new LinkedList<>();
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static boolean[][] check;
	static char[][] map;
	static int R, C, N;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check = new boolean[R][C];
		
		for (int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int height = 0, index = -1;
		while (true) {
			height = R - Integer.parseInt(st.nextToken());
			index = remove(height, 0, 1);
			if (index >= 0) {
				ground();
				drop(index);
				init();
			}
			
			if (--N == 0) break;
			
			height = R - Integer.parseInt(st.nextToken());
			index = remove(height, C-1, -1);
			if (index >= 0) {
				ground();
				drop(index);
				init();
			}
			
			if (--N == 0) break;
		}
		for (int i=0; i<R; i++) {
			sb.append(String.valueOf(map[i])).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int remove(int height, int index, int add) {
		while (true) {
			if (map[height][index] == 'x') {
				map[height][index] = '.';
				return index;
			}
			index += add;
			if (index < 0 || index >= C) break;
		}
		return -1;
	}
	
	static void ground() {
		for (int j=0; j<C; j++) {
			if (map[R-1][j] == 'x' && !check[R-1][j]) {
				BFS(R-1, j);
			}
		}
	}
	
	static void BFS(int x, int y) {
		queue.offer(new int[] {x, y});
		check[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '.' || check[nx][ny]) continue;
				
				queue.offer(new int[] {nx, ny});
				check[nx][ny] = true;
			}
		}
	}
	
	static void drop(int index) {
		int move_cnt = 0;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (!check[i][j] && map[i][j] == 'x') {
					move_cnt = all_drop(i, j);
					down(move_cnt);
					break;
				}
			}
		}
	}
	
	static int all_drop(int x, int y) {
		queue.offer(new int[] {x, y});
		check[x][y] = true;
		map[x][y] = 'o';
		int cnt = R;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || check[nx][ny]) continue;
				
				if (map[nx][ny] == '.') {
					if (d != 2) continue;
					
					int i = nx, move = 0;
					while (true) {
						if (i >= R || (map[i][ny] == 'x' && check[i][ny])) {
							cnt = Math.min(cnt, move);
							break;
						}
						move++; i++;
					}
					continue;
				}
				
				queue.offer(new int[] {nx, ny});
				check[nx][ny] = true;
				map[nx][ny] = 'o';
			}
		}
		return cnt;
	}
	
	static void down(int cnt) {
		for (int j=0; j<C; j++) {
			for (int i=R-1; i>=0; i--) {
				if (map[i][j] == 'o') {
					map[i][j] = '.';
					check[i][j] = false;
					
					map[i+cnt][j] = 'x';
					check[i+cnt][j] = true;
				}
			}
		}
	}
	
	static void init() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				check[i][j] = false;
			}
		}
	}
}
