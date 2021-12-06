import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] dist;
	static int V, E, answer;
	
	static int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws IOException {
		 String[] input = br.readLine().split(" ");
		 V = Integer.parseInt(input[0]);
		 E = Integer.parseInt(input[1]);
		 
		 dist = new int[V+1][V+1];
		 answer = INF;
		 
		 for (int i=1; i<=V; i++) {
			 Arrays.fill(dist[i], INF);
		 }
		 
		 while (E-- > 0) {
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 int c = Integer.parseInt(st.nextToken());
			 
			 dist[a][b] = c;
		 }
		 
		 floyd();
		 
		 for (int i=1; i<=V; i++) {
			answer = Math.min(answer, dist[i][i]);
		 }
		 
		 System.out.println(answer == INF ? -1 : answer);
	}
	
	public static void floyd() {
		for (int k=1; k<=V; k++) {
			for (int i=1; i<=V; i++) {
				for (int j=1; j<=V; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
