package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	public static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
	public static int[] dirY = {1, 1, 0, -1, -1, -1, 0, 1};
	public static int[][] mat;
	public static int N;
	public static int answer;
	
	public static void move(int cnt, int j, int m) {
		mat[cnt][j] += m;
		for (int k=0; k<8; k++) {
			int moveX = cnt, moveY = j;
			while (true) {
				moveX += dirX[k];
				moveY += dirY[k];
				if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= N) break; 
				mat[moveX][moveY] += m;
			}
		}
	}
	
	public static void DFS2(int cnt) {
		if (cnt == N) {
			answer++;
			return;
		}
		for (int j=0; j<N; j++) {
			if (mat[cnt][j] == 0) {
				move(cnt, j, 1);
				DFS2(cnt+1);
				move(cnt, j, -1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		
		DFS2(0);
		System.out.println(answer);
	}
}
