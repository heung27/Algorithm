# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 2660. 회장뽑기

## Classification
* 그래프 이론
* 그래프 탐색
* 너비 우선 탐색
* 플로이드-와샬

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2660_회장뽑기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dist;
	static int N;
	
	static int INF = Integer.MAX_VALUE >> 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		dist = new int[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == -1 && b == -1) break;
			
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		floyd();
		
		int[] score = new int[N+1];
		 
		int answer = INF;
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				score[i] = Math.max(score[i], dist[i][j]);
			}
			answer = Math.min(answer, score[i]);
		}
		
		int cnt = 0;
		for (int i=1; i<=N; i++) {
			if (score[i] == answer) {
				cnt++;
				sb.append(i).append(" ");
			}
		}
		
		bw.write(answer + " " + cnt + "\n");
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void floyd() {
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/2660
