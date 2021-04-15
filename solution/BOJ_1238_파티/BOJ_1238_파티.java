import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n, w;
		Node next;
		
		public Node(int n, int w, Node next) {
			this.n = n;
			this.w = w;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static Node[] list1, list2;
	static int[] dist1, dist2;
	static int N, M, X;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		X = Integer.parseInt(str[2]);
		
		list1 = new Node[N+1];
		list2 = new Node[N+1];
		
		dist1 = new int[N+1];
		dist2 = new int[N+1];
		
		Arrays.fill(dist1, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list1[from] = new Node(to, weight, list1[from]);
			list2[to] = new Node(from, weight, list2[to]);
		}
		
		dijkstra(list1, dist1);
		dijkstra(list2, dist2);
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			answer = Math.max(answer, dist1[i] + dist2[i]);
		}
		
		System.out.println(answer);
	}
	
	static void dijkstra(Node[] list, int[] dist) {
		boolean[] check = new boolean[N+1];
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(X, 0, list[X]));
		dist[X] = 0;
		
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if (check[temp.n]) continue;
			check[temp.n] = true;
			
			for (Node next = temp.next; next != null; next = next.next) {
				if (dist[next.n] > dist[temp.n] + next.w) {
					dist[next.n] = dist[temp.n]+ next.w;
					queue.offer(new Node(next.n, dist[next.n], list[next.n]));
				}
			}
		}
	}
}
