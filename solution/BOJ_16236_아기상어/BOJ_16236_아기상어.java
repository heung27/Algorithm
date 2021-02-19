import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] movex = {-1, 0, 0, 1};
	static int[] movey = {0, -1, 1, 0};
	static int[][] map;
	static boolean[][] check;
	static int[] shark;
	static int N, time, eat;
	static int fish_size = 2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		shark = new int[2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
				}
			}
		}
		
		while (BFS(shark[0], shark[1])) {}
		
		System.out.println(time);
	}
	
	static boolean BFS(int x, int y) {
		check_init();
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		check[x][y] = true;
		
		int[] temp = new int[] {N, N};
		boolean t = false;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				
				if (map[pos[0]][pos[1]] != 0 && map[pos[0]][pos[1]] < fish_size) {
					t = true;
					
					if (pos[0] < temp[0]) temp = pos;
					else if (pos[0] == temp[0] && pos[1] < temp[1]) temp = pos;
					
					continue;
				}
				for (int i=0; i<4; i++) {
					int nx = pos[0] + movex[i];
					int ny = pos[1] + movey[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					if (!check[nx][ny] && map[nx][ny] <= fish_size) {
						queue.offer(new int[] {nx,ny});
						check[nx][ny] = true;
					}
				}
			}
			if (t) {
				map[temp[0]][temp[1]] = 9;
				map[x][y] = 0;
				shark = temp;
				time += cnt;
				if (++eat == fish_size) {
					fish_size++;
					eat = 0;
				}
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	static void check_init() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				check[i][j] = false;
			}
		}
	}
}
