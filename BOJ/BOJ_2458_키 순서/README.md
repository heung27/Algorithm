# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 2458. 키 순서

## Classification
* 그래프 이론
* 그래프 탐색
* 깊이 우선 탐색
* 플로이드 와샬

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2458_키_순서 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[][] check1, check2;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		check1 = new boolean[N+1][N+1];
		check2 = new boolean[N+1][N+1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			check1[from][to] = true;
			check2[to][from] = true;
		}
		
		floyd(check1);
		floyd(check2);
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			int add = 1;
			for (int j=1; j<=N; j++) {
				if (i == j) continue;
				
				if (!check1[i][j] && !check2[i][j]) {
					add = 0;
					break;
				}
			}
			answer += add;
		}
		
		System.out.println(answer);
	}
	
	static void floyd(boolean[][] check) {
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				if (k == i) continue;
				
				for (int j=1; j<=N; j++) {
					if (k == j || i == j) continue;
					
					if (check[i][k] && check[k][j]) check[i][j] = true;
				}
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/2458
