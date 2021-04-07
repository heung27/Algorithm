import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1865_웜홀 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static class Edge {
		int from, to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static Edge[] edges;
	static int[] dist;
	static int N, M, W;
	static int E; // 간선의 개수
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		
		while (test-- > 0) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			
			E = M*2 + W;
			edges = new Edge[E];
			dist = new int[N+1];
			
			Arrays.fill(dist, Integer.MAX_VALUE >> 2);
			dist[1] = 0;
			
			int index = 0;
			while (M-- > 0) { // 무방향
				str = br.readLine().split(" ");
				int S = Integer.parseInt(str[0]);
				int E = Integer.parseInt(str[1]);
				int T = Integer.parseInt(str[2]); // 걸리는 시간
				
				edges[index++] = new Edge(S, E, T);
				edges[index++] = new Edge(E, S, T);
			}
			
			while (W-- > 0) { // 방향
				str = br.readLine().split(" ");
				int S = Integer.parseInt(str[0]);
				int E = Integer.parseInt(str[1]);
				int T = Integer.parseInt(str[2]); // 줄어드는 시간
				
				edges[index++] = new Edge(S, E, -T);
			}
			
			if (!bellman()) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean bellman() {
		for (int i=1; i<N; i++) { // N-1번 반복
			for (int j=0; j<E; j++) {
				int from = edges[j].from;
				int to = edges[j].to;
				int weight = edges[j].weight;
				
				if (dist[from] + weight < dist[to]) {
					dist[to] = dist[from] + weight;
				}
			}
		}
		
		for (int j=0; j<E; j++) { // 음수 사이클 확인
			int from = edges[j].from;
			int to = edges[j].to;
			int weight = edges[j].weight;
			
			if (dist[from] + weight < dist[to]) {
				return false; // 음의 사이클이 생기면 YES
			}
		}
		return true; // 음의 사이클이 없으면 NO
	}
}
