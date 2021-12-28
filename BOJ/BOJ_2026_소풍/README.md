# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 2026. 소풍

## Classification
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2026_소풍 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static Stack<Integer> stack = new Stack<>();
	
	static boolean[][] mat;
	static boolean[] visit;
	static int[] edges;
	static int K, N, F;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		mat = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		edges = new int[N+1];
		
		for (int i=0; i<F; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			mat[a][b] = mat[b][a] = true;
			edges[a]++; edges[b]++;
		}
		
		for (int i=1; i<=N; i++) {
			if (edges[i] < K-1) continue;
			
			stack.add(i);
			if (dfs(1, i)) break;
			stack.pop();
		}
		
		if (stack.isEmpty()) {
			sb.append(-1);
		} else {
			for (int x : stack) {
				sb.append(x).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean dfs(int cnt, int n) {
		visit[n] = true;
		if (cnt == K) {
			return true;
		}
		
		for (int i=n+1; i<=N; i++) {
			if (visit[i]) continue;
			
			boolean check = true;
			for (int temp : stack) {
				if (!mat[i][temp]) {
					check = false;
					break;
				}
			}
			
			if (check) {
				stack.add(i);
				if (dfs(cnt+1, i)) return true;
				stack.pop();
			}
		}
		visit[n] = false;
		return false;
	}
}
```

## Link
> https://www.acmicpc.net/problem/2026
