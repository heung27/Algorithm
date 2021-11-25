# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/15.svg" width="30"> 21611. 마법사 상어와 블리자드

## Classification
* 구현

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_21611_마법사_상어와_블리자드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	// 하우상좌
	static int[] movex = {1, 0, -1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][] mat;
	static int N, M;
	
	static int[] num;
	static int shark;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shark = N / 2;
		
		mat = new int[N][N];
		num = new int[4];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			if (d == 1) {
				d = 2;
			} else if (d == 2) {
				d = 0;
			} else if (d == 4) {
				d = 1;
			}
			
			hit(d, s);
			move();
			while (remove());
			change();
		}
		
		System.out.println(num[1] + (num[2] * 2) + (num[3] * 3));
	}
	
	public static void hit(int d, int s) {
		int x = shark, y = shark;
		for (int i=0; i<s; i++) {
			x += movex[d];
			y += movey[d];
			mat[x][y] = 0;
		}
	}
	
	public static void move() {
		int x = shark, y = shark-1, d = 0;
		int nx = x, ny = y, nd = d;
		
		int len = 1, cnt = 1, temp = 0;
		int nlen = 1, ncnt = 1;
		
		loop: while (true) {
			for (int k=0; k<nlen; k++) {
				if (mat[nx][ny] != 0) {
					int swap = mat[nx][ny];
					mat[nx][ny] = 0;
					mat[x][y] = swap;
					
					x = x + movex[d];
					y = y + movey[d];
					
					if (++temp == len) {
						temp = 0;
						d = (d + 1) % 4;
						if (++cnt == 2) {
							len++;
							cnt = 0;
						}
					}
				}
				if (nx == 0 && ny == 0) break loop;
				
				nx = nx + movex[nd];
				ny = ny + movey[nd];
			}
			nd = (nd + 1) % 4;
			if (++ncnt == 2) {
				nlen++;
				ncnt = 0;
			}
		}
	}
	
	public static boolean remove() {
		boolean boom = false;
		
		int nx = shark, ny = shark-1, nd = 0;
		int nlen = 1, ncnt = 1;
		
		int color = 0;
		
		Stack<int[]> stack = new Stack<>();
		
		loop: while (true) {
			for (int k=0; k<nlen; k++) {
				if (mat[nx][ny] == color) {
					stack.add(new int[] {nx, ny});
				} else {
					if (stack.size() >= 4) {
						while (!stack.isEmpty()) {
							int[] pos = stack.pop();
							mat[pos[0]][pos[1]] = 0;
							num[color]++;
						}
						boom = true;
					}
					stack.clear();
					stack.add(new int[] {nx, ny});
					color = mat[nx][ny];
				}
				
				if ((nx == 0 && ny == 0) || (mat[nx][ny] == 0)) {
					if (stack.size() >= 4) {
						while (!stack.isEmpty()) {
							int[] pos = stack.pop();
							mat[pos[0]][pos[1]] = 0;
							num[color]++;
						}
						boom = true;
					}
					break loop;
				}
				
				nx = nx + movex[nd];
				ny = ny + movey[nd];
			}
			nd = (nd + 1) % 4;
			if (++ncnt == 2) {
				nlen++;
				ncnt = 0;
			}
		}
		move();
		return boom;
	}
	
	public static void change() {
		int nx = shark, ny = shark-1, nd = 0;
		int nlen = 1, ncnt = 1;
		
		int cnt = 0, color = mat[nx][ny];
		
		if (color == 0) return;
		
		Queue<int[]> queue = new LinkedList<>();
		
		loop: while (true) {
			for (int k=0; k<nlen; k++) {
				if (mat[nx][ny] == color) {
					cnt++;
				} else {
					queue.offer(new int[] {cnt, color});
					color = mat[nx][ny];
					if (color == 0) break loop;
					cnt = 1;
				}
				
				if (nx == 0 && ny == 0) {
					queue.offer(new int[] {cnt, color});
					color = mat[nx][ny];
					cnt = 1;
					break loop;
				}
				
				nx = nx + movex[nd];
				ny = ny + movey[nd];
			}
			nd = (nd + 1) % 4;
			if (++ncnt == 2) {
				nlen++;
				ncnt = 0;
			}
		}
		
		check(queue);
	}
	
	public static void check(Queue<int[]> queue) {
		int x = shark, y = shark-1, d = 0;
		int len = 1, cnt = 1, temp = 0;
		
		loop: while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int i=0; i<2; i++) {
				mat[x][y] = pos[i];
				
				if (x == 0 && y == 0) break loop;
				
				x = x + movex[d];
				y = y + movey[d];
				
				if (++temp == len) {
					temp = 0;
					d = (d + 1) % 4;
					if (++cnt == 2) {
						len++;
						cnt = 0;
					}
				}
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/21611
