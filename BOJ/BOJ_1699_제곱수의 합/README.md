# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg" width="30"> 1699. 제곱수의 합

## Classification
* 수학
* 다이나믹 프로그래밍
* 정수론

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1699_제곱수의_합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		dp[1] = 1;
		
		for (int i=2; i<=N; i++) {
			dp[i] = dp[i-1]+1;
			
			int j = 2;
			while (j*j <= i) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
				j++;
			}
		}
		
		System.out.println(dp[N]);
	}
}
```

## Link
> https://www.acmicpc.net/problem/1699
