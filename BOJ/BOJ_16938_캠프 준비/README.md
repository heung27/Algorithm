# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 16938. 캠프 준비

## Classification
* 수학
* 브루트포스 알고리즘
* 조합론
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16938_캠프_준비 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] list;
	static int N, L, R, X;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		
		System.out.println(answer);
	}
	
	static void dfs(int cnt, int min, int max, int sum) {
		if (sum > R) return;
		if (cnt == N) {
			if (sum < L || max - min < X) return;
			answer++;
			return;
		}
		
		dfs(cnt+1, min, max, sum);
		
		min = Math.min(min, list[cnt]);
		max = Math.max(max, list[cnt]);
	
		dfs(cnt+1, min, max, sum+list[cnt]);
	}
}
```

## Link
> https://www.acmicpc.net/problem/16938
