# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/10.svg" width="30"> 12852. 1로 만들기 2

## Classification
* 다이나믹 프로그래밍
* 그래프 이론
* 그래프 탐색

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_12852_1로_만들기_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		int[] parent = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		
		int temp;
		for (int i=1; i<N; i++) {
			temp = i * 2;
			if (temp <= N && dp[temp] > dp[i]+1) {
				dp[temp] = dp[i]+1;
				parent[temp] = i;
			}
			
			temp = i * 3;
			if (temp <= N && dp[temp] > dp[i]+1) {
				dp[temp] = dp[i]+1;
				parent[temp] = i;
			}
			
			temp = i + 1;
			if (temp <= N && dp[temp] > dp[i]+1) {
				dp[temp] = dp[i]+1;
				parent[temp] = i;
			}
		}
		
		sb.append(dp[N]).append("\n");
		int p = N;
		while (p != 0) {
			sb.append(p).append(" ");
			p = parent[p];
		}
		System.out.println(sb.toString());
	}
}
```

## Link
> https://www.acmicpc.net/problem/12852
