import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map, psum;
	static int N, M, C;
	static int answer, memo;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			answer = 0;
			map = new int[N][N];
			psum = new int[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<=N-M; j++) {
					memo = 0;
					memo(0, i, j, 0, 0);
					psum[i][j] = memo;
				}
			}
			
			DFS(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int cnt, int num, int sum) {
		if (cnt == 2) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i=num; i<N*N; i++) {
			int x = i / N;
			int y = i % N;
			
			if (y > N-M) continue;
			
			DFS(cnt+1, i+M, sum+psum[x][y]);
		}
	}
	
	static void memo(int cnt, int row, int col, int sum, int add) {
		if (cnt == M) {
			memo = Math.max(add, memo);
			return;
		}
		memo(cnt+1, row, col+1, sum, add);
		
		if (sum + map[row][col] > C) return;
		
		memo(cnt+1, row, col+1, sum + map[row][col], add + map[row][col] * map[row][col]);
		
	}
}
