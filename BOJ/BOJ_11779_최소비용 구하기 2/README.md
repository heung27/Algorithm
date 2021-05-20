# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 11779. 최소비용 구하기 2

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
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11779_최소비용_구하기_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node>{
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
			return this.weight - o.weight;
		}
	}
	
	static Node[] list;
	static int[] dist, pre;
	static boolean[] visit;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		list = new Node[N+1];
		dist = new int[N+1];
		pre = new int[N+1];
		visit = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		sb.append(dijkstra(start, end)).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		stack.add(end);
		int temp = pre[end];
		while (temp != start) {
			stack.add(temp);
			temp = pre[temp];
		}
		stack.add(start);
		
		sb.append(stack.size()).append("\n");
		while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int dijkstra(int start, int end) {
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
					pre[next.n] = node.n;
					queue.offer(new Node(next.n, dist[next.n]));
				}
			}
		}
		return -1;
	}
}
```

## Link
> https://www.acmicpc.net/problem/11779
