# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 16724. 피리 부는 사나이

## Classification
* 그래프 이론
* 자료 구조
* 그래프 탐색
* 깊이 우선 탐색
* 분리 집합

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16724_피리_부는_사나이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	static int cnt = 1;
	
	static int[][] visit;
	static int[][] map;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		visit = new int[N][M];
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				if (s.charAt(j) == 'U') {
					map[i][j] = 0;
				} else if (s.charAt(j) == 'R') {
					map[i][j] = 1;
				} else if (s.charAt(j) == 'D') {
					map[i][j] = 2;
				} else {
					map[i][j] = 3;
				}
			}
		}
		
		int answer = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (visit[i][j] == 0) {
					if (DFS(i, j)) answer++;
					cnt++;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean DFS(int i, int j) {
		int x = i, y = j;
		visit[x][y] = cnt;
		
		while (true) {
			int nx = x + movex[map[x][y]];
			int ny = y + movey[map[x][y]];
			
			if (visit[nx][ny] != 0) {
				if (visit[nx][ny] == cnt) return true;
				else return false;
			}
			
			visit[nx][ny] = cnt;
			
			x = nx; y = ny;
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/16724
