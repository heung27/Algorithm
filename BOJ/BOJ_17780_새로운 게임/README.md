# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 17780. 새로운 게임

## Classification
* 구현
* 문자열
* 시뮬레이션

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_17780_새로운_게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Node {
		int x, y, d;
		boolean isBottom;
		
		public Node(int x, int y, int d, boolean isBottom) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.isBottom = isBottom;
		}
	}
	
	static class Map {
		Deque<Integer> queue;
		int color;
		
		public Map(int color) {
			this.queue = new ArrayDeque<>();
			this.color = color;
		}
	}
	
	static int[] movex = {0, 0, 0, -1, 1};
	static int[] movey = {0, 1, -1, 0, 0};
	
	static Map[][] map;
	static Node[] list;
	static int N, K, time;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		map = new Map[N+1][N+1];
		list = new Node[K];
		
		for (int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			for (int j=1; j<=N; j++) {
				map[i][j] = new Map(Integer.parseInt(str[j-1]));
			}
		}
		
		for (int i=0; i<K; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int d = Integer.parseInt(str[2]);
			
			list[i] = new Node(x, y, d, true);
			map[x][y].queue.offer(i);
		}
		
		while (++time <= 1000 && move()) {}
		
		if (time == 1001) System.out.println(-1);
		else System.out.println(time);
	}
	
	static boolean move() {
		boolean check = false;
		
		for (int i=0; i<K; i++) {
			if (!list[i].isBottom) continue;
			
			int x = list[i].x, y = list[i].y, d = list[i].d;
			
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny].color == 2) {
				if (!check) {
					if (d == 1) list[i].d = 2;
					else if (d == 2) list[i].d = 1;
					else if (d == 3) list[i].d = 4;
					else if (d == 4) list[i].d = 3;
					
					check = true;
					i--;
				}
				else check = false;
				continue;
			}
			
			Deque<Integer> queue = map[x][y].queue;
			Deque<Integer> next_queue = map[nx][ny].queue;
			list[i].isBottom = false;
			
			if (map[nx][ny].color == 1) {
				while (!queue.isEmpty()) {
					int num = queue.pollLast();
					list[num].x = nx;
					list[num].y = ny;
					map[nx][ny].queue.offer(num);
				}
			}
			else {
				while (!queue.isEmpty()) {
					int num = queue.pollFirst();
					list[num].x = nx;
					list[num].y = ny;
					next_queue.offer(num);
				}
			}
			if (next_queue.size() >= 4) return false;
			
			int bottom = next_queue.peekFirst();
			list[bottom].isBottom = true;
			
			check = false;
		}
		return true;
	}
}
```

## Link
> https://www.acmicpc.net/problem/17780
