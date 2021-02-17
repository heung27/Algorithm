import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬_디펜스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {0, -1, 0};
	static int[] movey = {-1, 0, 1};
	static int[][] map, map_temp;
	static boolean[][] check;
	static int[] numbers;
	static int N, M, D;
	static int cnt, answer, kill, temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		D = Integer.parseInt(str[2]);
		map = new int[N][M];
		map_temp = new int[N][M];
		check = new boolean[N][M];
		numbers = new int[3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map_temp[i][j] = Integer.parseInt(st.nextToken());
				if (map_temp[i][j] == 1) temp++;
			}
		}
		combination(0, 0);
		
		System.out.println(answer);
	}
	
	static void combination(int x, int start) {
		if (x == 3) {
			kill = 0;
			cnt = temp;
			map_init();
			while (cnt > 0) {
				for (int k=0; k<3; k++) {
					init();
					BFS(N-1, numbers[k]);
				}
				down();
			}
			answer = Math.max(answer, kill);
			return;
		}
		for (int i=start; i<M; i++) {
			numbers[x] = i;
			combination(x+1, i+1);
		}
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		check[x][y] = true;
		int dis = 1;
		
		while (!queue.isEmpty()) {
			if (dis > D) return;
			
			int size = queue.size();
			while (size-- > 0) {
				int[] pos = queue.poll();
				if (map[pos[0]][pos[1]] == 1) {
					map[pos[0]][pos[1]] = -1;
					cnt--;
					kill++;
					return;
				}
				else if (map[pos[0]][pos[1]] == -1) return;
				
				for (int i=0; i<3; i++) {
					int nx = pos[0] + movex[i];
					int ny = pos[1] + movey[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if (!check[nx][ny]) {
						queue.offer(new int[] {nx, ny});
						check[nx][ny] = true;
					}
				}
			}
			dis++;
		}
	}
	
	static void down() {
		for (int j=0; j<M; j++) {
			if (map[N-1][j] == 1) cnt--; // 적의 수 감소
		}
		for (int j=0; j<M; j++) {
			for (int i=N-2; i>=0; i--) {
				map[i+1][j] = map[i][j] == -1 ? 0 : map[i][j];
			}
		}
		for (int j=0; j<M; j++) {
			map[0][j] = 0;
		}
	}
	
	static void init() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				check[i][j] = false;
			}
		}
	}
	
	static void map_init() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j] = map_temp[i][j];
			}
		}
	}
}
