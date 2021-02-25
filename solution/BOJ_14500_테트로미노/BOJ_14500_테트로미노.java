import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static boolean[][] check;
	static int[][] map;
	static int N, M;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		check = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				check[i][j] = true;
				DFS(i, j, 1, map[i][j]);
				check[i][j] = false;
				func(i, j);
			}
		}
		System.out.println(answer);
	}
	
	static void DFS(int x, int y, int depth, int sum) {
		if (depth == 4) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i=0; i<4; i++) {
			int nx = x + movex[i];
			int ny = y + movey[i];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			if (!check[nx][ny]) {
				check[nx][ny] = true;
				DFS(nx, ny, depth+1, sum+map[nx][ny]);
				check[nx][ny] = false;
			}
		}
	}
	
	static void func(int x, int y) {
		if (x > 0 || y > 0 || x < N-1 || y < M-1) {
			int sum = map[x][y];
			int min = Integer.MAX_VALUE;
			boolean t = false;
			
			for (int i=0; i<4; i++) {
				int nx = x + movex[i];
				int ny = y + movey[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					t = true;
					continue;
				}
				
				sum += map[nx][ny];
				if (!t) min = Math.min(min, map[nx][ny]);
			}
			
			if (!t) sum -= min;
			answer = Math.max(answer, sum);
		}
	}
}
