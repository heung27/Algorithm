# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 1766. 문제집

## Classification
* 그래프 이론
* 자료 구조
* 우선순위 큐
* 위상 정렬

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n;
		Node next;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}
		
		public Node(int n) {
			this.n = n;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.n, o.n);
		}
	}
	
	static Node[] list;
	static int[] in_degree;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		list = new Node[N+1];
		in_degree = new int[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a] = new Node(b, list[a]);
			in_degree[b]++;
		}
		
		topological_sort();
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void topological_sort() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		for (int i=1; i<=N; i++) {
			if (in_degree[i] == 0) queue.offer(new Node(i));
		}
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			sb.append(node.n).append(" ");
			
			for (Node next = list[node.n]; next != null; next = next.next) {
				if (--in_degree[next.n] == 0) queue.offer(new Node(next.n));
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/1766
