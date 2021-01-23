package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1780 {
	static int[][] map;
	static int[] cnt = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		map = new int[num+1][num+1];
		StringTokenizer st;
		for (int i=1; i<num+1; i++) {
			st = new StringTokenizer(br.readLine());
			int j=1;
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		solution(1, 1, num);
		for (int i=0; i<3; i++) {
			System.out.println(cnt[i]);
		}
		br.close();
	}
	
	static void solution(int x, int y, int len) {
		int current = map[x][y];
		boolean t = false;
		a: for (int i=x; i<x+len; i++) {
			for (int j=y; j<y+len; j++) {
				if (map[i][j] != current) {
					t = true;
					break a;
				}
			}
		}
		if (t) {
			int size = len/3;
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					solution(x + (size * i), y + (size * j), size);
				}
			}
		}
		else cnt[current+1]++;
	}
}
