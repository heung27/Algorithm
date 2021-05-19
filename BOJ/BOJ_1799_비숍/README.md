# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 1799. 비숍

## Classification
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1799_비숍 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<int[]> white = new ArrayList<>();
	static ArrayList<int[]> black = new ArrayList<>();
	
	static int[][] map;
	static boolean[] check1, check2;
	static int N, answer;
	static int max1, max2;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check1 = new boolean[N*2];
		check2 = new boolean[N*2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) {
					if ((i+j) % 2 == 0) white.add(new int[] {i, j});
					else black.add(new int[] {i, j});
				}
			}
		}
		
		SubSet(white, 0, 0, 1);
		SubSet(black, 0, 0, 0);
		
		System.out.println(max1 + max2);
	}
	
	static void SubSet(ArrayList<int[]> list, int cnt, int num, int color) {
		if (cnt == list.size()) {
			if (color == 0) max1 = Math.max(max1, num);
			else max2 = Math.max(max2, num);
			return;
		}
		
		int[] pos = list.get(cnt);
		
		int x = pos[0];
		int y = pos[1];
		
		if (check(x, y)) {
			check1[x+y] = true;
			check2[x-y+N-1] = true;
			
			SubSet(list, cnt+1, num+1, color);
			
			check1[x+y] = false;
			check2[x-y+N-1] = false;
		}
		
		SubSet(list, cnt+1, num, color);
	}
	
	static boolean check(int x, int y) {
		if (check1[x+y] || check2[x-y+N-1]) {
			return false;
		}
		else return true;
	}
}
```

## Link
> https://www.acmicpc.net/problem/1799
