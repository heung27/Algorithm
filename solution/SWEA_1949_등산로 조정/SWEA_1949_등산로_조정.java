
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_등산로_조정 {
	public static int[][] map;
	public static boolean[][] check;
	public static int[] moveX = {0, 1, 0, -1};
	public static int[] moveY = {1, 0, -1, 0};
	public static int N, K, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			check = new boolean[N][N];
			answer = 0;
			int max = 0;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) max = map[i][j];
				}
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == max) {
						DFS(i, j, 1, false);
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void DFS(int x, int y, int cnt, boolean k_check) {
		check[x][y] = true;
		int cur = map[x][y];
		for (int i=0; i<4; i++) {
			int nextX = x+moveX[i];
			int nextY = y+moveY[i];
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
			if (!check[nextX][nextY]) {
				if (map[nextX][nextY] < cur) {
					DFS(nextX, nextY, cnt+1, k_check);
				}
				if (!k_check) {
					for (int k=1; k<=K; k++) {
						if (map[nextX][nextY]-k < cur) {
							map[nextX][nextY] -= k;
							DFS(nextX, nextY, cnt+1, true);
							map[nextX][nextY] += k;
						}
					}
				}
			}
		}
		check[x][y] = false;
		if (answer < cnt) answer = cnt;
	}
}
