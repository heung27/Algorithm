import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형_방 {
	static int[] dirX = {1, 0, 0, -1}; // 하 왼 오 상
	static int[] dirY = {0, -1, 1, 0};
	static int[][] map;
	static boolean[][] check;
	static int N, answer, value, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t=1; t<=tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 1;
			value = Integer.MAX_VALUE;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					cnt = 0;
					DFS(i, j);
					if (answer < cnt) {
						answer = cnt;
						value = map[i][j];
					}else if (answer == cnt) {
						if (value > map[i][j]) value = map[i][j]; 
					}
				}
			}
			System.out.println("#"+t+" "+value+" "+answer);
		}
	}
	
	static void DFS(int x, int y) {
		check[x][y] = true;
		cnt++;
		for (int i=0; i<4; i++) {
			int nextX = x+dirX[i];
			int nextY = y+dirY[i];
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
			if (!check[nextX][nextY] && map[x][y] + 1 == map[nextX][nextY]) {
				DFS(nextX, nextY);
			}
		}
		check[x][y] = false;
	}
}
