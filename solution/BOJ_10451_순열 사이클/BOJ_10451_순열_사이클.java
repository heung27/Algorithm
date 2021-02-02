package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451_순열_사이클 {
	public static int[] map, check;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			map = new int[num+1];
			check = new int[num+1];
			answer = 1;
			for (int i=1; i<=num; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			for (int i=1; i<=num; i++) {
				if (check[i] == 0) move(i);
			}
			System.out.println(answer-1);
		}
	}
	public static void move(int start) {
		while (true) {
			check[start] = answer;
			int next = map[start];
			if (check[next] == answer) {
				answer++;
				break;
			}
			start = next;
		}
	}
}
