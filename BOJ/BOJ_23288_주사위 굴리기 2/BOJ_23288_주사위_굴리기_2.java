import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_23288_주사위_굴리기_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	// 상 하 좌 우 앞 뒤
	static int[] dice = {1, 6, 4, 3, 5, 2};
	
	// 상우하좌
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static boolean[][] visit;
	static int[][] mat;
	static int N, M, K;
	
	static int x, y;
	static int d = 1;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		mat = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		while (K-- > 0) {
			move();
			check();
			visit = new boolean[N][M];
			answer += score(x, y) * mat[x][y];
		}
		
		System.out.println(answer);
	}
	
	public static void move() {
		int nx = x + movex[d];
		int ny = y + movey[d];
		
		if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
			d = (d + 2) % 4;
			nx = x + movex[d];
			ny = y + movey[d];
		}
		
		x = nx; y = ny;
		
		int temp = dice[0];
		switch (d) {
		case 0:
			dice[0] = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[5];
			dice[5] = temp;
			break;
		case 1:
			dice[0] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[3];
			dice[3] = temp;
			break;
		case 2:
			dice[0] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[4];
			dice[4] = temp;
			break;
		case 3:
			dice[0] = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[2];
			dice[2] = temp;
			break;
		}
	}
	
	public static void check() {
		if (dice[1] > mat[x][y]) {
			d = (d + 1) % 4;
		} else if (dice[1] < mat[x][y]) {
			d = (d + 3) % 4;
		}
	}
	
	public static int score(int x, int y) {
		visit[x][y] = true;
		
		int sum = 1;
		for (int d=0; d<4; d++) {
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny]) continue;
			
			if (mat[nx][ny] == mat[x][y]) {
				sum += score(nx, ny);
			}
		}
		return sum;
	}
}
