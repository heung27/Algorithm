package com.ssafy.ws02.step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
	static int[] direct_x = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] direct_y = {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int k=1; k<=test; k++) {
			int max = 0;
			int num = Integer.parseInt(br.readLine());
			String[][] build = new String[num][num];
			StringTokenizer st;
			for (int i=0; i<num; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<num; j++) {
					build[i][j] = st.nextToken();

				}
			}
			for (int i=0; i<num; i++) {
				for (int j=0; j<num; j++) {
					if (build[i][j].equals("B")) {
						int cnt = -1;
						int z;
						for (z=0; z<8; z++) {
							int x = i + direct_x[z];
							int y = j + direct_y[z];
							if (x >= 0 && x < num && y >= 0 && y < num) {
								if (build[x][y].equals("G")) {
									if (max < 2) max = 2;
									break;
								}
							}
						}
						if (z == 8) {
							for (z=0; z<num; z++) {
								if (build[i][z].equals("B")) cnt++;
								if (build[z][j].equals("B")) cnt++;
							}
							if (max < cnt) max = cnt;
						}
					}
				}
			}
			System.out.println("#"+k+" "+max);
		}
		br.close();
	}
}
