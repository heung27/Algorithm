# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/9.svg" width="30"> 5567. 결혼식

## Classification
* 구현
* 그래프 이론
* 그래프 탐색

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
	
	static boolean[] visit;
	static Node[] nodes;
	static int N, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N+1];
		visit = new boolean[N+1];
		
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a] = new Node(b, nodes[a]);
			nodes[b] = new Node(a, nodes[b]);
		}
		visit[1] = true;
		DFS(1, 0);
		
		System.out.println(answer);
	}
	
	static void DFS(int n, int cnt) {
		if (cnt == 2) return;
		
		for (Node next = nodes[n]; next != null; next = next.next) {
			if (!visit[next.n]) {
				answer++;
				visit[next.n] = true;
			}
			DFS(next.n, cnt+1);
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/5567
