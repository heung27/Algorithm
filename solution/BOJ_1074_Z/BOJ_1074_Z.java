package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1074_Z {
	public static int N; // 안씀
	public static int X, Y, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		X = Integer.parseInt(str[1]);
		Y = Integer.parseInt(str[2]);
		for (int i=0; X != 0 || Y != 0; i+=2) {
			if (X%2 == 1) answer += Math.pow(2, i+1);
			if (Y%2 == 1) answer += Math.pow(2, i);
			X = X/2;
			Y = Y/2;
		}
		System.out.println(answer);
	}
}
