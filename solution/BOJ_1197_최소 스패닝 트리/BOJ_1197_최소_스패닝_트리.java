import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소_스패닝_트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Edge implements Comparable<Edge> {
		int from, to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	
	static int[] parents;
	static int V, E;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		V = Integer.parseInt(str[0]);
		E = Integer.parseInt(str[1]);
		
		parents = new int[V+1];
		
		for (int i=1; i<=V; i++) {
			parents[i] = i;
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			queue.offer(new Edge(from, to, weight));
		}
		
		int cnt = 0, answer = 0;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (union(edge.from, edge.to)) {
				answer += edge.weight;
				cnt++;
				if (cnt == V-1) break;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean union(int n1, int n2) {
		int r1 = find(n1);
		int r2 = find(n2);
		
		if (r1 == r2) return false;
		else if (r1 < r2) parents[r1] = r2;
		else parents[r2] = r1;
		return true;
	}
	
	static int find(int n) {
		if (n ==  parents[n]) return n;
		return parents[n] = find(parents[n]);
	}
}
