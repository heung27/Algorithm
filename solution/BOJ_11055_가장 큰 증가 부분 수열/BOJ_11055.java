package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_11055 {
	public static int[] mat;
	public static int[] dp;
	public static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		mat = new int[size];
		dp = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<size; i++) {
			mat[i] = Integer.parseInt(st.nextToken());
			dp[i] = mat[i];
		}
		for (int i=1; i<size; i++) {
			for (int j=i-1; j>=0; j--) {
				if (mat[i] > mat[j] && dp[i] < dp[j] + mat[i]) {
					dp[i] = dp[j] + mat[i];
				}
			}
		}
		int max = 0;
		for (int i=0; i<size; i++) {
			if (max < dp[i]) max = dp[i];
		}
		System.out.println(max);
	}
}
