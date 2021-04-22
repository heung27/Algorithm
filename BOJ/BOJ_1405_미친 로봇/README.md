# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 1405. 미친 로봇

## Classification
* 그래프 이론
* 그래프 탐색
* 브루트포스 알고리즘
* 깊이 우선 탐색
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1405_미친_로봇 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] movex = {0, 0, -1, 1};
	static int[] movey = {1, -1, 0, 0};
	
	static double[] arr = new double[4];
	
	static boolean[][] check;
	static int N;
	static double answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		int len = (N + 1) << 1;
		
		check = new boolean[len][len];
		
		for (int i=0; i<4; i++) {
			arr[i] = Double.parseDouble(str[i+1]) * 0.01;
		}
		
		check[N][N] = true;
		DFS(0, N, N, 1.0);
		
		System.out.println(answer);
	}
	
	static void DFS(int cnt, int x, int y, double sum) {
		if (cnt == N) {
			answer += sum;
			return;
		}
		for (int d=0; d<4; d++) {
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (check[nx][ny]) continue;
			
			check[nx][ny] = true;
			DFS(cnt + 1, x + movex[d], y + movey[d], sum * arr[d]);
			check[nx][ny] = false;
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/1405
