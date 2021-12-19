import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] group, mat;
	static int N = 6, M = 3;
	static int size = 15; // 6C2
	
	public static void main(String[] args) throws IOException {
		group = new int[size][2];
		mat = new int[N][M];
		
		int index = 0;
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				group[index][0] = i;
				group[index++][1] = j;
			}
		}
		
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			for (int x=0; x<N; x++) {
				for (int y=0; y<M; y++) {
					mat[x][y] = Integer.parseInt(st.nextToken());
					sum += mat[x][y];
				}
			}
			
			if (sum != 30) {
				sb.append(0);
			} else {
				sb.append(dfs(0) ? 1 : 0);
			}
			
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean dfs(int cnt) {
		if (cnt == size) {
			return true;
		}
		
		int a = group[cnt][0];
		int b = group[cnt][1];
		
		for (int k=0; k<3; k++) {
			if (mat[a][k] > 0 && mat[b][2-k] > 0) {
				mat[a][k]--; mat[b][2-k]--;
				if (dfs(cnt+1)) return true;
				mat[a][k]++; mat[b][2-k]++;
			}
		}
		
		return false;
	}
}
