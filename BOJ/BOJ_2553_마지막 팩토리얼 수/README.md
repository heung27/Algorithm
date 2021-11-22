# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/10.svg" width="30"> 2553. 마지막 팩토리얼 수

## Classification
* 수학
* 정수론

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2553_마지막_팩토리얼_수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dp = new int[20001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 1;
		
		System.out.println(func(N));
	}
	
	public static int func(int N) {
		if (dp[N] == 0) {
			if (N % 5 == 0) {
				int q = N / 5;
				dp[N] = ((int) Math.pow(2, q % 4) * func(q)) % 10;
			} else {
				int total = 1;
				int before = (N / 5) * 5;
				
				for (int i=N; i > before; i--) {
					total *= (i % 10) ;
				}
				total *= func(before);
				dp[N] = total % 10;
			}
		}
		return dp[N];
	}
}
```

## Link
> https://www.acmicpc.net/problem/2553
