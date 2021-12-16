# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/10.svg" width="30"> 1106. 호텔

## Classification
* 다이나믹 프로그래밍
* 배낭 문제

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int INF = Integer.MAX_VALUE >> 1;
	static int LEN;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		LEN = N + 100 + 1;
		
		int[] dp = new int[LEN];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j=b; j<LEN; j++) {
				dp[j] = Math.min(dp[j], dp[j-b]+a);
			}
		}
		
		int answer = INF;
		for (int i=N; i<LEN; i++) {
			answer = Math.min(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}
```

## Link
> https://www.acmicpc.net/problem/1106
