import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] dist;
	static int[] list;
	static int N, M, R;
	static int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		dist = new int[N+1][N+1];
		list = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (i == j) continue;
				dist[i][j] = INF;
			}
		}
		
		while (R-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			dist[a][b] = dist[b][a] = l;
		}
		
		floy();
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			int sum = 0;
			for (int j=1; j<=N; j++) {
				if (dist[i][j] <= M) sum += list[j];
			}
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}
	
	static void floy() {
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				if (k == i) continue;
				for (int j=1; j<=N; j++) {
					if (k == j || j == i) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
