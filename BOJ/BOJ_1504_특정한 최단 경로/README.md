# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 1504. 특정한 최단 경로

## Classification
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

public class BOJ_1504_특정한_최단_경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n, weight;
		Node next;
		
		public Node(int n, int weight, Node next) {
			this.n = n;
			this.weight = weight;
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
	static int[] dist;
	static boolean[] visit;
	static int N, E;
	static int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		E = Integer.parseInt(str[1]);
		
		list = new Node[N+1];
		dist = new int[N+1];
		visit = new boolean[N+1];
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
			list[to] = new Node(from, weight, list[to]);
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int between = dijkstra(A, B);
		int case1 = dijkstra(1, A) + dijkstra(B, N);
		int case2 = dijkstra(1, B) + dijkstra(A, N);
		
		int answer = -1;
		if (between < INF && (case1 < INF || case2 < INF)) {
			answer = Math.min(case1, case2) + between;
		}
		
		System.out.println(answer);
	}
	
	static int dijkstra(int start, int end) {
		for (int i=1; i<=N; i++) {
			dist[i] = INF;
			visit[i] = false;
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.n == end) return node.weight;
			
			if (visit[node.n]) continue;
			visit[node.n] = true;
			
			for (Node next = list[node.n]; next != null; next = next.next) {
				if (dist[next.n] > node.weight + next.weight) {
					dist[next.n] = node.weight + next.weight;
					queue.offer(new Node(next.n, dist[next.n]));
				}
			}
		}
		
		return INF;
	}
}
```

## Link
> https://www.acmicpc.net/problem/1504
