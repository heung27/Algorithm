import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1600_말이_되고픈_원숭이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Horse {
		int x, y;
		int k;
		
		public Horse(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[] movexx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] moveyy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int[][] map, check;
	static int R, C, K;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[1]);
		C = Integer.parseInt(str[0]);
		
		map = new int[R][C];
		check = new int[R][C];
		
		for (int i=0; i<R; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		if (BFS()) System.out.println(answer);
		else System.out.println(-1);
	}
	
	static boolean BFS() {
		Queue<Horse> queue = new LinkedList<>();
		queue.offer(new Horse(0, 0, K+1));
		check[0][0] = K+1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				Horse pos = queue.poll();
				
				if (pos.x == R-1 && pos.y == C-1) return true;
				
				for (int d=0; d<4; d++) {
					int nx = pos.x + movex[d];
					int ny = pos.y + movey[d];
					
					if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					
					if (map[nx][ny] == 0 && check[nx][ny] < pos.k) {
						queue.offer(new Horse(nx, ny, pos.k));
						check[nx][ny] = pos.k;
					}
				}
				
				if (pos.k == 1) continue;
				
				for (int d=0; d<8; d++) {
					int nx = pos.x + movexx[d];
					int ny = pos.y + moveyy[d];
					
					if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					
					if (map[nx][ny] == 0 && check[nx][ny] < pos.k-1) {
						queue.offer(new Horse(nx, ny, pos.k-1));
						check[nx][ny] = pos.k-1;
					}
				}
			}
			answer++;
		}
		return false;
	}
}
