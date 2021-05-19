import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4066_All_Pair_Shortest_Path {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dist;
	static int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			
			dist = new int[N+1][N+1];
			
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (i == j) continue;
					dist[i][j] = INF;
				}
			}
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				dist[from][to] = Math.min(dist[from][to], weight);
			}
			
			floyd(N);
			
			sb.append("#").append(t);
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					sb.append(" ").append(dist[i][j] == INF ? -1 : dist[i][j]);
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void floyd(int N) {
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				if (k == i) continue;
				
				for (int j=1; j<=N; j++) {
					if (k == j || i == j) continue;
					
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
