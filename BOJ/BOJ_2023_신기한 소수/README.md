# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 2023. 신기한 소수

## Classification
* 그래프 이론
* 그래프 탐색
* 깊이 우선 탐색
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2023_신기한_소수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		DFS(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int cnt, int sum) {
		if (!check(sum)) return;
		else if (cnt == N) {
			sb.append(sum).append("\n");
			return;
		}
		for (int i=1; i<10; i++) {
			DFS(cnt+1, sum*10+i);
		}
	}
	
	static boolean check(int num) {
		if (num == 1) return false;
		int sqrt = (int)Math.sqrt(num);
		for (int i=2; i<=sqrt; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
```

## Link
> https://www.acmicpc.net/problem/2023
