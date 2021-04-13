import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1263_사람_네트워크2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dist;
	static int N;
	
	static int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dist = new int[N][N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && dist[i][j] == 0) dist[i][j] = INF;
				}
			}
			
			floyd();
			
			int min = Integer.MAX_VALUE;
			for (int i=0; i<N; i++) {
				int sum = 0;
				for (int j=0; j<N; j++) {
					sum += dist[i][j];
				}
				min = Math.min(min, sum);
			}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void floyd() {
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				if (i == k) continue;
				for (int j=0; j<N; j++) {
					if (j == k || i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
