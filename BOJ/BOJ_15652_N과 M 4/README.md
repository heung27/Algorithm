# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg" width="30"> 15652. N과 M (4)

## Classification
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15652_N과_M_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] list, numbers;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		list = new int[N+1];
		numbers = new int[M];
		for (int i=1; i<=N; i++) {
			list[i] = i;
		}
		
		DFS(0, 1);
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int cnt, int start) {
		if (cnt == M) {
			for (int i=0; i<cnt; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=start; i<=N; i++) {
			numbers[cnt] = i;
			DFS(cnt + 1, i);
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/15652
