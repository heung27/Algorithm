import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17396_백도어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n;
		long w;
		Node next;
		
		public Node(int n, long w, Node next) {
			this.n = n;
			this.w = w;
			this.next = next;
		}
		
		public Node(int n, long w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	static Node[] list;
	static boolean[] visit;
	static long[] dist;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		dist = new long[N];
		list = new Node[N];
		
		Arrays.fill(dist, Long.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N-1; i++) {
			int flag = Integer.parseInt(st.nextToken());
			if (flag == 1) dist[i] = 0;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
			list[to] = new Node(from, weight, list[to]);
		}
		
		System.out.println(dijkstra());
	}
	
	static long dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(0, 0));
		dist[0] = 0;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (visit[node.n]) continue;
			visit[node.n] = true;
			
			if (node.n == N-1) return node.w;
			
			for (Node next = list[node.n]; next != null; next = next.next) {
				if (dist[next.n] > dist[node.n] + next.w) {
					dist[next.n] = dist[node.n] + next.w;
					queue.offer(new Node(next.n, dist[next.n]));
				}
			}
		}
		return -1;
	}
}
