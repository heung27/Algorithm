import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_11780_플로이드_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static Stack<Integer> stack = new Stack<>();
	
	static int[][] dist, pre;
	static int N, M;
	static int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1][N+1];
		pre = new int[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (i == j) continue;
				dist[i][j] = INF;
			}
		}
		
		for (int i=0; i<M; i++) {
			String[] str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);
			int weight = Integer.parseInt(str[2]);
			
			dist[from][to] = Math.min(dist[from][to], weight);
			pre[from][to] = from;
		}
		
		floyd();
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (dist[i][j] == INF) dist[i][j] = 0;
				sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (pre[i][j] != 0) {
					int cnt = 2, temp = pre[i][j];
					while (true) {
						stack.add(temp);
						if (temp == i) break;
						temp = pre[i][temp];
						cnt++;
					}
					sb.append(cnt).append(" ");
					while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
					sb.append(j);
				}
				else sb.append("0");
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void floyd() {
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				if (k == i) continue;
				for (int j=1; j<=N; j++) {
					if (k == j || i == j) continue;
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
	}
}
