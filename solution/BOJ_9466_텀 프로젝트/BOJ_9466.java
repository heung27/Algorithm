package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
	public static int[] students;
	public static boolean[] check;
	public static int[] search;
	public static int answer;
	
	public static void DFS(int start, int cnt) {
		search[start] = cnt;
		check[start] = true;
		int next = students[start];
		if (check[next]) {
			if (search[next] == -1) answer += cnt;
			else answer += search[next]-1;
		}
		else DFS(next, cnt+1);
		search[start] = -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int i=0; i<test; i++) {
			int num = Integer.parseInt(br.readLine());
			check = new boolean[num+1];
			students = new int[num+1];
			search = new int[num+1];
			answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=num; j++) {
				students[j] = Integer.parseInt(st.nextToken());
				search[students[j]]++;
			}
			for (int j=1; j<=num; j++) {
				if (search[j] == 0) {
					DFS(j, 1);
				}
			}
			System.out.println(answer);
		}
	}
}
