# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 14923. 미로 탈출

## Classification
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
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14923_미로_탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][] mat;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int Hx = Integer.parseInt(st.nextToken())-1;
		int Hy = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		int Ex = Integer.parseInt(st.nextToken())-1;
		int Ey = Integer.parseInt(st.nextToken())-1;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(BFS(Hx, Hy, Ex, Ey));
	}
	
	public static int BFS(int Hx, int Hy, int Ex, int Ey) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		int[][] visit = new int[N][M];
		queue.offer(new int[] {Hx, Hy, 0, 1});
		visit[Hx][Hy] = 1;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			if (pos[0] == Ex && pos[1] == Ey) {
				return pos[2];
			}
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (visit[nx][ny] == pos[3] || (visit[nx][ny] == 1 && pos[3] == 2)) continue;
				
				if (mat[nx][ny] == 0) {
					queue.offer(new int[] {nx, ny, pos[2]+1, pos[3]});
					visit[nx][ny] = pos[3];
				} else if (pos[3] == 1) {
					queue.offer(new int[] {nx, ny, pos[2]+1, 2});
					visit[nx][ny] = 2;
				}
			}
			
		}
		return -1;
	}
}
```

## Link
> https://www.acmicpc.net/problem/14923
