package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2304 {
	public static class Pair implements Comparable<Pair> {
		public int x;
		public int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pair o) {
			return this.x - o.x;
		}
	}
	public static Pair[] mat;
	public static int maxY;
	public static int num;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		num = Integer.parseInt(br.readLine());
		mat = new Pair[num];
		for (int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			mat[i] = new Pair(x, y);
			if (maxY < y) maxY = y;
		}
		Arrays.sort(mat);
		if (num == 1) answer = maxY;
		else {
			Pair left_p = mat[0];
			for (int i=1; i<num; i++) { // 왼쪽부터 넓이 계산
				if (left_p.y < mat[i].y) {
					answer += (mat[i].x - left_p.x) * left_p.y;
					left_p = mat[i];
					if (mat[i].y == maxY) break;
				}
			}
			Pair right_p = mat[num-1];
			for (int i=num-2; i>=0; i--) { // 오른쪽부터 넓이 계산
				if (right_p.y < mat[i].y) {
					answer += (right_p.x - mat[i].x) * right_p.y;
					right_p = mat[i];
					if (mat[i].y == maxY) break;
				}
			}
			answer += (right_p.x - left_p.x + 1) * maxY;
		}
		System.out.println(answer);
	}
}
