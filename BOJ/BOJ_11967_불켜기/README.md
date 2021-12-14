# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 11967. 불켜기

## Classification
* 구현
* 그래프 이론
* 그래프 탐색
* 너비 우선 탐색

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11967_불켜기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static ArrayList[][] map;
	static int N, M;
	static int answer = 1;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1][N+1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (map[x][y] == null) {
				map[x][y] = new ArrayList<int[]>();
			}
			map[x][y].add(new int[] {a, b});
		}
		
		BFS();
		
		System.out.println(answer);
	}
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		
		boolean[][] visit = new boolean[N+1][N+1];
		boolean[][] check = new boolean[N+1][N+1];
		boolean[][] mat = new boolean[N+1][N+1];
		
		queue.offer(new int[] {1, 1});
		visit[1][1] = mat[1][1] = true;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			if (!check[pos[0]][pos[1]]) {
				check[pos[0]][pos[1]] = true;
				ArrayList<int[]> list = map[pos[0]][pos[1]];
				
				if (list != null) {
					for (int[] temp : list) {
						if (!mat[temp[0]][temp[1]]) {
							if (visit[temp[0]][temp[1]]) {
								queue.offer(new int[] {temp[0], temp[1]});
							}
							mat[temp[0]][temp[1]] = true;
							answer++;
						}
					}
				}
			}
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 1 || nx > N || ny < 1 || ny > N || visit[nx][ny]) continue;
				
				if (mat[nx][ny]) {
					queue.offer(new int[] {nx, ny});
				}
				visit[nx][ny] = true;
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/11967
