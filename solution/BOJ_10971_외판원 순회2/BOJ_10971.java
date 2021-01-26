package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_10971 {
	public static int[][] mat;
	public static boolean[] check;
	public static int size;
	public static int answer;
	
	public static void solution(int x, int cnt, int temp) {
		if (cnt == size-1) {
			if (mat[x][0] != 0) {
				temp += mat[x][0];
				if (answer > temp) {
					answer = temp;
				}
			}
			return;
		}
		check[x] = true;
		for (int i=0; i<size; i++) {
			if (!check[i] && mat[x][i] != 0) {
				solution(i, cnt+1, temp+mat[x][i]);
			}
		}
		check[x] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		size = Integer.parseInt(br.readLine());
		mat = new int[size][size];
		check = new boolean[size];
		answer = Integer.MAX_VALUE;
		for (int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<size; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solution(0, 0, 0);
		System.out.println(answer);
	}
}