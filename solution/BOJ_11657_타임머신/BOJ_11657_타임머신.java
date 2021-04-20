import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node {
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static long INF = Long.MAX_VALUE >> 1;
	
	static Node[] map;
	static long[] dist;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new Node[N+1];
		dist = new long[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[from] = new Node(to, weight, map[from]);
		}
		
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		if (!Bellman_Ford()) {
			for (int i=2; i<=N; i++) {
				if (dist[i] == INF) dist[i] = -1;
				sb.append(dist[i]).append("\n");
			}
		}
		else sb.append("-1").append("\n");
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean Bellman_Ford() {
		boolean check = false;
		
		for (int i=0; i<N; i++) {
			check = false;
			for (int from=1; from<=N; from++) {
				if (dist[from] == INF) continue;
				
				for (Node node = map[from]; node != null; node = node.next) {
					if (dist[node.to] > dist[from] + node.weight) {
						dist[node.to] = dist[from] + node.weight;
						check = true;
					}
				}
			}
			if (!check) break;
		}
		
		return check;
	}
}
