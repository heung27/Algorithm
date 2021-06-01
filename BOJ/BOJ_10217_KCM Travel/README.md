# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/15.svg" width="30"> 10217. KCM Travel

## Classification
* 다이나믹 프로그래밍
* 그래프 이론
* 다익스트라

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10217_KCM_Travel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n, cost, weight;
		Node next;
		
		public Node(int n, int cost, int weight, Node next) {
			this.n = n;
			this.cost = cost;
			this.weight = weight;
			this.next = next;
		}
		
		public Node(int n, int cost, int weight) {
			this.n = n;
			this.cost = cost;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Node[] list;
	static int[][] dist;
	static int N, M, K;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			list = new Node[N+1];
			dist = new int[N+1][M+1];
			
			for (int i=1; i<=N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[from] = new Node(to, cost, weight, list[from]);
			}
			
			int result = dijkstra();
			if (result < 0) sb.append("Poor KCM");
			else sb.append(result);
			sb.append("\n");
		}
		bw.append(sb.toString());
		bw.flush();
	}
	
	static int dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(1, 0, 0));
		Arrays.fill(dist[1], 0);
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.n == N) return node.weight;
			
			if (dist[node.n][node.cost] < node.weight) continue;
			 
			for (Node next = list[node.n]; next != null; next = next.next) {
				int cost = node.cost + next.cost;
				if (cost <= M && dist[next.n][cost] > node.weight + next.weight) {
					int weight = node.weight + next.weight;
					int temp = cost;
					
					while (temp <= M && dist[next.n][temp] > weight) {
						dist[next.n][temp++] = weight;
					}
					
					queue.offer(new Node(next.n, cost, weight));
				}
			}
		}
		
		return -1;
	}
}
```

## Link
> https://www.acmicpc.net/problem/10217
