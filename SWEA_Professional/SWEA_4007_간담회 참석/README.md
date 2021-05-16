# [D4] 4007. 간담회 참석

## Classification
* 다익스트라

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_4007_간담회_참석 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n, weight;
		Node next;
		
		public Node(int n, int weight, Node next) {
			this.n = n;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static boolean[] visit1, visit2;
	static int[] dist1, dist2;
	static Node[] list1, list2;
	static int N, M, X;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			dist1 = new int[N+1];
			dist2 = new int[N+1];
			
			visit1 = new boolean[N+1];
			visit2 = new boolean[N+1];
			
			list1 = new Node[N+1];
			list2 = new Node[N+1];
			
			for (int i=1; i<=N; i++) {
				dist1[i] = Integer.MAX_VALUE;
				dist2[i] = Integer.MAX_VALUE;
			}
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list1[from] = new Node(to, weight, list1[from]);
				list2[to] = new Node(from, weight, list2[to]);
			}
			
			dijkstra(visit1, dist1, list1);
			dijkstra(visit2, dist2, list2);
			
			int max = 0;
			for (int i=1; i<=N; i++) {
				max = Math.max(max, dist1[i]+dist2[i]);
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dijkstra(boolean[] visit, int[] dist, Node[] list) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(X, 0, list[X]));
		dist[X] = 0;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (visit[node.n]) continue;
			visit[node.n] = true;
			
			for (Node temp = node.next; temp != null; temp = temp.next) {
				if (dist[temp.n] > dist[node.n] + temp.weight) {
					dist[temp.n]= dist[node.n] + temp.weight;
					queue.offer(new Node(temp.n, dist[temp.n], list[temp.n]));
				}
			}
		}
	}
}
```

## Link
> https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDj5qAAfw5UW6&subjectId=AWWxyoNqAiQDFAW4
