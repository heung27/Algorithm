# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/15.svg" width="30"> 2098. 외판원 순회

## Classification
* 다이나믹 프로그래밍
* 비트마스킹
* 비트필드를 이용한 다이나믹 프로그래밍
* 외판원 순회 문제

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2098_외판원_순회 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int INF = Integer.MAX_VALUE >> 1;
	
	static int[][] cost;
	static int[][] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		dp = new int[N][1<<N];
		
		for (int i=0; i<N; i++) {
			Arrays.fill(dp[i], INF);
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				if (cost[i][j] == 0) cost[i][j] = INF;
			}
		}
		
		System.out.println(DFS(0, 1));
	}
	
	static int DFS(int n, int flag) {
		if (flag == (1<<N)-1) {
			return cost[n][0];
		}
		
		if (dp[n][flag] != INF) {
			return dp[n][flag];
		}
		
		for (int i=0; i<N; i++) {
			if ((flag & 1<<i) != 0) continue;
			
			dp[n][flag] = Math.min(dp[n][flag], DFS(i, flag | 1<<i) + cost[n][i]);
		}
		return dp[n][flag];
	}
}
```

## Link
> https://www.acmicpc.net/problem/2098
