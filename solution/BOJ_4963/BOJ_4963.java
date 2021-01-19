package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_4963 {
	static int[] direct_x = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] direct_y = {1, 1, 0, -1, -1, -1, 0, 1};
	static String[] map;
	static boolean[][] check;
	static int H, W;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int cnt =0;
			String[] s = br.readLine().split(" ");
			W = Integer.parseInt(s[0]);
			H = Integer.parseInt(s[1]);
			if (W == 0 && H == 0) break;
			
			map = new String[H];
			check = new boolean[H][W];
			StringTokenizer st;
			for (int i=0; i<H; i++) {
				map[i] = "";
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens())
					map[i] += st.nextToken();
			}
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (!check[i][j] && map[i].charAt(j) == '1') {
						solution(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static void solution(int x, int y) {
		check[x][y] = true;
		for (int i=0; i<8; i++) {
			int xx = x + direct_x[i];
			int yy = y + direct_y[i];
			if ( xx >= 0 && xx < H && yy >= 0 && yy < W) {
				if (!check[xx][yy] && map[xx].charAt(yy) == '1') {
					solution(xx, yy);
				}
			}
		}
	}
}
