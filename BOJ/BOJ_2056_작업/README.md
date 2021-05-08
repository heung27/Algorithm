# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 2056. 작업

## Classification
* 다이나믹 프로그래밍
* 그래프 이론
* 위상 정렬

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node {
		int n;
		Node next;
		
		public Node(int n, Node next) {
			super();
			this.n = n;
			this.next = next;
		}
	}
	
	static Node[] list;
	static int[] degree, weights, time;
	static int N, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		list = new Node[N+1];
		degree = new int[N+1];
		weights = new int[N+1];
		time = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int weight = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			degree[i] = cnt;
			weights[i] = weight;
			
			for (int j=0; j<cnt; j++) {
				int from = Integer.parseInt(st.nextToken());
				list[from] = new Node(i, list[from]);
			}
		}
		
		sol();
		
		System.out.println(answer);
	}
	
	static void sol() {
		Queue<Node> queue = new LinkedList<>();
		
		for (int i=1; i<=N; i++) {
			if (degree[i] == 0) queue.offer(new Node(i, null));
		}
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			answer = Math.max(answer, time[node.n] + weights[node.n]);
			
			for (Node next = list[node.n]; next != null; next = next.next) {
				time[next.n] = Math.max(time[next.n], time[node.n] + weights[node.n]);
				
				if (--degree[next.n] == 0) {
					queue.offer(new Node(next.n, null));
				}
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/2056
