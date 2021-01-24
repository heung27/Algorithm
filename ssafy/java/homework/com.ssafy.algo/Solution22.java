package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution22 {
	static int[] direct_x = {-1, 1, 0, 0};
	static int[] direct_y = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			boolean[][] check = new boolean[n][n];
			int cnt = 0;
			int salt = Integer.parseInt(st.nextToken());
			for (int i=0; i<salt; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				if (!check[x][y]) {
					for (int j=1; j<=6; j++) {
						x += direct_x[dir];
						y += direct_y[dir];
						if (x < 0 || x >= n || y < 0 || y >= n) break;
						if (j == 3 || i == 5) {
							if (check[x][y]) break;
						}
						else if (j == 6) {
							if (!check[x][y]) {
								check[x][y] = true;
								cnt++;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		br.close();
	}
}
