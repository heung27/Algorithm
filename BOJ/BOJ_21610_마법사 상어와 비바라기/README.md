# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 21610. 마법사 상어와 비바라기

## Classification
* 구현
* 시뮬레이션

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21610_마법사_상어와_비바라기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static ArrayList<int[]> cloud = new ArrayList<>();
	
	static int[] movex = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] movey = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	static int[][] map;
	static boolean[][] check;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cloud.add(new int[] {N-2, 0});
		cloud.add(new int[] {N-1, 0});
		cloud.add(new int[] {N-2, 1});
		cloud.add(new int[] {N-1, 1});
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			moveNrain(d, s);
			makeCloud();
		}
		
		int answer = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
	
	static void moveNrain(int d, int s) {
		for (int[] p : cloud) {
			p[0] = (p[0] + movex[d] * (s%N) + N) % N;
			p[1] = (p[1] + movey[d] * (s%N) + N) % N;
			map[p[0]][p[1]]++;
		}
		waterCopy();
	}
	
	static void waterCopy() {
		for (int[] p : cloud) {
			int cnt = 0;
			
			for (int d=2; d<=8; d+=2) {
				int x = p[0] + movex[d];
				int y = p[1] + movey[d];
				
				if (x < 0 || x >= N || y < 0 || y >= N) continue;
				
				if (map[x][y] != 0) cnt++;
			}
			
			map[p[0]][p[1]] += cnt;
			check[p[0]][p[1]] = true;
		}
	}
	
	static void makeCloud() {
		cloud.clear();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (check[i][j]) {
					check[i][j] = false;
					continue;
				}
				if (map[i][j] >= 2) {
					map[i][j] -= 2;
					cloud.add(new int[] {i, j});
				}
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/21610
