# [D4] 3947. 가장 짧은 길 전부 청소하기

## Classification
* 다익스트라
* Shortest Path DAG

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3947_가장_짧은_길_전부_청소하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int to;
		long weight;
		Node next;
		
		public Node(int to, long weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static boolean[] visit = new boolean[200001];
	static long[] DAG_weight = new long[200001];
	static long[] dist = new long[200001];
	static Node[] list = new Node[200001];
	
	static int N, M;
	static long answer;
	
	static long INF = Long.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = 0;
			
			for (int i=1; i<=N; i++) {
				dist[i] = INF;
				DAG_weight[i] = 0;
				visit[i] = false;
				list[i] = null;
			}
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				long weight = Integer.parseInt(st.nextToken());
				
				list[from] = new Node(to, weight, list[from]);
				list[to] = new Node(from, weight, list[to]);
			}
			
			dijkstra(1);
			
			for (int i=2; i<=N; i++) answer += DAG_weight[i];
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0, list[start]));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (visit[node.to]) continue;
			visit[node.to] = true;
			
			for (Node temp = node.next; temp != null; temp = temp.next) {
				if (dist[temp.to] > node.weight + temp.weight) {
					dist[temp.to] = node.weight + temp.weight;
					DAG_weight[temp.to] = temp.weight; // 최단 거리로 오는 간선 가중치 선택
					queue.offer(new Node(temp.to, dist[temp.to], list[temp.to]));
				}
				else if (dist[temp.to] == node.weight + temp.weight) {
					if (DAG_weight[temp.to] > temp.weight) {
						DAG_weight[temp.to] = temp.weight; // 최단 거리로 오는 간선 중 가장 작은 가중치 선택
					}
				}
			}
		}
	}
}
```

## Link
> https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDj5qAAfw5UW6&subjectId=AWWxxej6Ae4DFAW4
