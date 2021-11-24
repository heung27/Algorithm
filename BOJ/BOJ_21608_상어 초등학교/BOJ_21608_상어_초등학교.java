import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21608_상어_초등학교 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][] mat;
	static int[][] lines;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		mat = new int[N+1][N+1];
		lines = new int[N*N+1][4];
		
		for (int i=0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for (int j=0; j<4; j++) {
				lines[n][j] = Integer.parseInt(st.nextToken());
			}
			
			put(lines[n], n);
		}
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				int cnt = 0;
				for (int d=0; d<4; d++) {
					int nx = i + movex[d];
					int ny = j + movey[d];
					
					if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
					
					for (int k=0; k<4; k++) {
						if (mat[nx][ny] == lines[mat[i][j]][k]) {
							cnt++;
						}
					}
				}
				if (cnt != 0) {
					answer += (int)Math.pow(10, cnt-1);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void put(int[] line, int n) {
		int[][] cnt = new int[N+1][N+1];
		int max = 0;
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				for (int k=0; k<4; k++) {
					if (line[k] == mat[i][j]) {
						for (int d=0; d<4; d++) {
							int nx = i + movex[d];
							int ny = j + movey[d];
							
							if (nx < 1 || nx > N || ny < 1 || ny > N || mat[nx][ny] != 0) continue;
							
							cnt[nx][ny]++;
							max = Math.max(max, cnt[nx][ny]);
						}
					}
				}
			}
		}
		
		int x = 0, y = 0;
		int empty = -1;
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (cnt[i][j] == max && mat[i][j] == 0) {
					int ecnt = 0;
					
					for (int d=0; d<4; d++) {
						int nx = i + movex[d];
						int ny = j + movey[d];
						
						if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
						
						if (mat[nx][ny] == 0) ecnt++;
					}
					
					if (empty < ecnt) {
						empty = ecnt;
						x = i; y = j;
					}
				}
			}
		}
		
		mat[x][y] = n;
	}
}
