import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구_이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map;
	static boolean[][] check;
	static int N, L, R;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean t = true;
		while (true) {
			t = false;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (!check[i][j] && BFS(i, j)) t = true;
				}
			}
			if (!t) break;
			answer++;
			init();
		}
		
		System.out.println(answer);
	}
	
	static boolean BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> temp = new LinkedList<>();
		queue.offer(new int[] {x, y});
		check[x][y] = true;
		int sum = 0, cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			sum += map[pos[0]][pos[1]];
			cnt++;
			
			for (int i=0; i<4; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				int diff = Math.abs(map[pos[0]][pos[1]] - map[nx][ny]);
				if (!check[nx][ny] && diff >= L && diff <= R) {
					queue.offer(new int[] {nx, ny});
					temp.offer(new int[] {nx, ny});
					check[nx][ny] = true;
				}
			}
		}
		if (cnt == 1) return false;
		
		int insert = sum / cnt;
		map[x][y] = insert;
		while(!temp.isEmpty()) {
			int[] pos = temp.poll();
			map[pos[0]][pos[1]] = insert;
		}
		return true;
	}
	
	static void init() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				check[i][j] = false;
			}
		}
	}
}
