import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4179_불 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Queue<int[]> qfire = new LinkedList<>();
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[] start = new int[2];
	
	static char[][] map;
	static boolean[][] check;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new char[N][M];
		check = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				
				if (map[i][j] == 'J') {
					start[0] = i;
					start[1] = j;
				}
				else if (map[i][j] == 'F') {
					qfire.add(new int[] {i, j});
				}
			}
		}
		
		int answer = BFS();
		System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
	}
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0], start[1]});
		check[start[0]][start[1]] = true;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				
				if (map[pos[0]][pos[1]] == 'F') continue;
				
				for (int d=0; d<4; d++) {
					int nx = pos[0] + movex[d];
					int ny = pos[1] + movey[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) return cnt;
					
					if (map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
					
					if (!check[nx][ny]) {
						queue.offer(new int[] {nx, ny});
						check[nx][ny] = true;
					}
				}
			}
			fire();
		}
		
		return -1;
	}
	
	static void fire() {
		int size = qfire.size();
		
		while (size-- > 0) {
			int[] pos = qfire.poll();
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
				
				qfire.offer(new int[] {nx, ny});
				map[nx][ny] = 'F';
			}
		}
	}
}
