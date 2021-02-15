import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_9205_맥주_마시면서_걸어가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dist;
	static int[][] point;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			N= Integer.parseInt(br.readLine())+2;
			point = new int[N][2];
			dist = new int[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<N; i++) {
				for (int j=i+1; j<N; j++) {
					int distance = Math.abs(point[i][0] - point[j][0]) + Math.abs(point[i][1] - point[j][1]);
					if (distance > 1000) distance = Integer.MAX_VALUE >> 1;
					dist[i][j] = distance;
					dist[j][i] = distance;
				}
			}
			
			floyd();
			
			if (dist[0][N-1] == Integer.MAX_VALUE >> 1) sb.append("sad");
			else sb.append("happy");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void floyd() { // 플로이드 연습
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
