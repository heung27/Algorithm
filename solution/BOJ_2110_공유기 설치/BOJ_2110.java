package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	public static int[] house;
	public static boolean check;
	public static int N;
	public static int C;
	
	public static void search() {
		int answer = 0;
		int left = 1, right = house[N-1] - house[0];
		while (left <= right) {
			int distance = (left + right)/2;
			int temp = 0, cnt = 1;
			for (int i=0; i<N; i++) {
				if (house[i] - house[temp] >= distance) {
					cnt++;
					temp = i;
				}
			}
			if (cnt < C) {
				right = distance-1;
			}
			else {
				answer = distance;
				left = distance+1;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		search();
	}
}
