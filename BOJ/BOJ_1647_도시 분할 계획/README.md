# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 1647. 도시 분할 계획

## Classification
* 그래프 이론
* 최소 스패닝 트리

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시_분할_계획 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Edge implements Comparable<Edge> {
		int a, b;
		int weight;
		
		public Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	static int[] root;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		root = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			root[i] = i;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			queue.offer(new Edge(a, b, weight));
		}
		
		
		int answer = 0, cnt = 0;
		while (cnt < N-2) {
			Edge edge = queue.poll();
			if (union(edge.a, edge.b)) {
				answer += edge.weight;
				cnt++;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return false;
		root[b] = a;
		return true;
	}
	
	static int find(int n) {
		if (n == root[n]) return n;
		return root[n] = find(root[n]);
	}
}
```

## Link
> https://www.acmicpc.net/problem/1647
