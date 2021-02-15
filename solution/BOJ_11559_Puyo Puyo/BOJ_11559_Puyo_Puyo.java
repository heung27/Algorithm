import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11559_Puyo_Puyo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] dir_X = {-1, 1, 0, 0};
	static int[] dir_Y = {0, 0, -1, 1};
	static char[][] map = new char[12][6];
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		for (int i=0; i<12; i++) {
			String str = br.readLine();
			for (int j=0; j<6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		while (true) {
			boolean t = false;
			for (int i=11; i>=0; i--) {
				for (int j=0; j<6; j++) {
					if (map[i][j] != '.') {
						if (BFS(i, j)) t = true;
					}
				}
			}
			if (!t) break;
			cnt++;
			down();
		}
		
		System.out.println(cnt);
	}
	
	static boolean BFS(int x, int y) {
		Queue<int []> queue = new LinkedList<int[]>();
		ArrayList<int[]> list = new ArrayList<>();
		
		queue.add(new int[] {x,y});
		char c = map[x][y];
		map[x][y] = '.';
		int boom = 0;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			list.add(pos);
			boom++;
			int nx, ny;
			for (int i=0; i<4; i++) {
				nx = pos[0] + dir_X[i];
				ny = pos[1] + dir_Y[i];
				if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
				if (map[nx][ny] == c) {
					queue.add(new int[] {nx, ny});
					map[nx][ny] = '.';
				}
			}
		}
		if (boom < 4) {
			for (int i=0; i<list.size(); i++) {
				int[] pos = list.get(i);
				map[pos[0]][pos[1]] = c;
			}
			return false;
		}
		return true;
	}
	
	static void down() {
		for (int j=0; j<6; j++) {
			int i = 11;
			int d = 0;
			boolean t = false;
			for ( ; i>=0; i--) {
				if (map[i][j] != '.') {
					if (t) break;
				}
				else {
					t = true;
					d++;
				}
			}
			if (d > 0) {
				int x = 0;
				for ( ; i>=0; i--, d++) {
					if (map[i][j] != '.') {
						map[i+d-x][j] = map[i][j];
						map[i][j] = '.';
						x++;
					}
				}
			}
		}
	}
}
