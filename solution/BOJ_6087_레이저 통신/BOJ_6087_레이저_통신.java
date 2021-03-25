import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_6087_레이저_통신 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] start = new int[2][2];
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][][] distance;
	static char[][] map;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		C = Integer.parseInt(str[0]);
		R = Integer.parseInt(str[1]);
		
		map = new char[R][C];
		distance = new int[R][C][4];
		
		int c = 0;
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				Arrays.fill(distance[i][j], Integer.MAX_VALUE-1);
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'C') {
					start[c][0] = i;
					start[c++][1] = j;
				}
			}
		}
		
		BFS();
		int min = Integer.MAX_VALUE;
		for (int i=0; i<4; i++) {
			min = Math.min(min, distance[start[0][0]][start[0][1]][i]);
		}
		System.out.println(min);
	}
	
	static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		for (int d=0; d<4; d++) {
			queue.offer(new int[] {start[1][0], start[1][1], d});
			distance[start[1][0]][start[1][1]][d] = 0;
		}
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int dir = pos[2];
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '*') continue;
				
				int cnt = distance[pos[0]][pos[1]][dir];
				if (dir != d) cnt++;
				
				if (cnt < distance[nx][ny][d]) {
					queue.offer(new int[] {nx, ny, d});
					distance[nx][ny][d] = cnt;
				}
			}
		}
	}
}
