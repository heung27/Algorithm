# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 10282. 해킹

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

public class BOJ_10282_해킹 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n, t;
		Node next;

		public Node(int n, int t, Node next) {
			this.n = n;
			this.t = t;
			this.next = next;
		}
		
		public Node(int n, int t) {
			this.n = n;
			this.t = t;
		}

		@Override
		public int compareTo(Node o) {
			return this.t - o.t;
		}
	}
	
	static Node[] list;
	static int[] dist;
	static int N, M, K;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			list = new Node[N+1];
			dist = new int[N+1];
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				list[b] = new Node(a, s, list[b]);
			}
			
			int cnt = dijkstra(K);
			
			sb.append(cnt).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static int dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		int cnt = 0;
		
		queue.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (visit[node.n]) continue;
			visit[node.n] = true;
			cnt++;
			
			answer = dist[node.n];
			
			for (Node next = list[node.n]; next != null; next = next.next) {
				if (dist[next.n] > node.t + next.t) {
					dist[next.n] = node.t + next.t;
					queue.offer(new Node(next.n, dist[next.n]));
				}
			}
		}
		
		return cnt;
	}
}
```

## Link
> https://www.acmicpc.net/problem/10282
