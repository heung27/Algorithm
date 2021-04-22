# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg" width="30"> 15655. N과 M (6)

## Classification
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_15655_N과_M_6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] list, numbers;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		list = new int[N];
		numbers = new int[M];
		
		str = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			list[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(list);
		
		DFS(0, 0);
		
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
		for (int i=start; i<N; i++) {
			numbers[cnt] = list[i];
			DFS(cnt + 1, i+1);
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/15655
