import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACM_Craft {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n, weight;
		Node next;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}

		public Node(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Node[] list;
	static int[] cost, in_degree;
	static int N, K, W;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			
			list = new Node[N+1];
			cost = new int[N+1];
			in_degree = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list[x] = new Node(y, list[x]);
				in_degree[y]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			sb.append(topological()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int topological() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		for (int i=1; i<=N; i++) {
			if (in_degree[i] == 0) {
				queue.offer(new Node(i, cost[i]));
			}
		}
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.n == W) return node.weight;
			
			for (Node next = list[node.n]; next != null; next = next.next) {
				if (--in_degree[next.n] == 0) {
					queue.offer(new Node(next.n, node.weight + cost[next.n]));
				}
			}
		}
		
		return -1;
	}
}
