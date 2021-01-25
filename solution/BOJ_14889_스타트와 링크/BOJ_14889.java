package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14889 {
	public static int[][] mat;
	public static boolean[] check;
	public static int result;
	public static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		size = Integer.parseInt(br.readLine());
		mat = new int[size][size];
		check = new boolean[size];
		for (int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<size; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				mat[j][i] += mat[i][j];
			}
		}
		result = Integer.MAX_VALUE;
		DFS(0, 0);
		System.out.println(result);
	}
	
	public static void DFS(int num, int A_cnt) {
		if (A_cnt == size/2) {
			int dif = 0;
			for (int i=0; i<size-1; i++) {
				for (int j=i+1; j<size; j++) {
					if (check[i] && check[j]) dif += mat[i][j];
					else if (!check[i] && !check[j]) dif -= mat[i][j];  
				}
			}
			dif = Math.abs(dif);
			if (result > dif) result = dif;
			return;
		}
		if (num < size) { 
			check[num] = true;
			DFS(num+1, A_cnt+1);
			check[num] = false;
			DFS(num+1, A_cnt);
		}
	}
}
