# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 2206. 벽 부수고 이동하기

## classification
* 그래프 이론
* 그래프 탐색
* 너비 우선 탐색


## link
> https://www.acmicpc.net/problem/10942


## code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point {
		int x, y;
		int t;
		
		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, -1, 0, 1};
	
	static boolean[][][] check;
	static int[][] map;
	static int M, N;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		check = new boolean[N][M][2];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0));
		check[0][0][0] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				Point pos = queue.poll();
				
				if (pos.x == N-1 && pos.y == M-1) return cnt;
				
				for (int i=0; i<4; i++) {
					int nx = pos.x + movex[i];
					int ny = pos.y + movey[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					if (map[nx][ny] == 0) {
						if (check[nx][ny][pos.t]) continue;
						
						queue.offer(new Point(nx, ny, pos.t));
						check[nx][ny][pos.t] = true;
					}
					else if (pos.t == 0) {
						if (check[nx][ny][1]) continue;
						
						queue.offer(new Point(nx, ny, 1));
						check[nx][ny][1] = true;
					}
				}
			}
			cnt++;
		}
		return -1;
	}
}
```
