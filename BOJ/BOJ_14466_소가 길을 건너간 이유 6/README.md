# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 14466. 소가 길을 건너간 이유 6

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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466_소가_길을_건너간_이유_6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static class Cow {
		int flag;
		boolean isCow;
	}
	
	static Cow[][] map;
	static int N, K, R;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		map = new Cow[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				map[i][j] = new Cow();
			}
		}
		
		while (R-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int d=0; d<4; d++) {
				if (x1 + movex[d] == x2 && y1 + movey[d] == y2) {
					map[x1][y1].flag |= 1 << d;
					map[x2][y2].flag |= 1 << (d+2)%4;
					break;
				}
			}
		}
		
		ArrayList<int[]> list = new ArrayList<>();
		for (int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y].isCow = true;
			list.add(new int[] {x, y});
		}
		
		for (int[] pos : list) {
			BFS(pos[0], pos[1]);
		}
		
		System.out.println((K * K - answer)/2);
	}
	
	static void BFS(int x, int y) {
		boolean[][] check = new boolean[N+1][N+1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		check[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			if (map[pos[0]][pos[1]].isCow) answer++;
			
			for (int d=0; d<4; d++) {
				if ((map[pos[0]][pos[1]].flag & (1 << d)) != 0) continue;
				
				
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 1 || nx > N || ny < 1 || ny > N || check[nx][ny]) continue;
				
				queue.offer(new int[] {nx, ny});
				check[nx][ny] = true;
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/14466
