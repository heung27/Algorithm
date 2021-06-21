# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 7579. 앱

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
import java.util.StringTokenizer;

public class BOJ_7579_앱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] arr, cost, dp;
	static int N, M, answer;
	static int size = 10001;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		cost = new int[N];
		dp = new int[size];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<N; i++) {
			for (int j=10000; j>=cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-cost[i]] + arr[i]);
			}
		}
		
		for (int i=0; i<=10000; i++) {
			if (dp[i] >= M) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
```

## Link
> https://www.acmicpc.net/problem/7579
