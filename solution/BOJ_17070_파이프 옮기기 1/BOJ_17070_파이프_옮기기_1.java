import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17070_파이프_옮기기_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map;
	static int N, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(1, 2, 0);
		System.out.println(answer);
	}
	
	static void DFS(int x, int y, int shape) {
		if (x == N && y == N) {
			answer++;
			return;
		}
		
		int nx, ny;
		if (shape != 0) { // 가로가 아니면
			nx = x + 1;
			ny = y;
			
			if (nx <= N && map[nx][ny] == 0) DFS(nx, ny, 1);
		}
		if (shape != 1) { // 세로가 아니면
			nx = x;
			ny = y + 1;
			
			if (ny <= N && map[nx][ny] == 0) DFS(nx, ny, 0);
		}
		
		nx = x + 1;
		ny = y + 1;
	
		if (nx > N || ny > N) return;
		
		if (map[nx][ny] == 0 && map[nx-1][ny] == 0 && map[nx][ny-1] == 0) DFS(nx, ny, 2);
	}
}
