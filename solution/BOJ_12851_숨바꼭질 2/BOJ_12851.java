package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12851 {
	public static int N;
	public static int K;
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[N<K?K*2+1:N*2+1];
		int level = 0, cnt_pop = 0, cnt_temp = 1, cnt_add = 0;
		q.add(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			check[cur] = true;
			if (cur == K) break;
			
			if (cur-1 >= 0 && !check[cur-1]) {
				q.add(cur-1);
				cnt_add++;
			}
			if (cur+1 <= K && !check[cur+1]) {
				q.add(cur+1);
				cnt_add++;
			}
			if (cur < K && !check[cur*2]) {
				q.add(cur*2);
				cnt_add++;
			}

			cnt_pop++;
			if (cnt_temp == cnt_pop) { // 레벨 계산
				cnt_temp = cnt_add;
				level++;
				cnt_pop = 0;
				cnt_add = 0;
			}
		}
		int answer = 1;
		while (!q.isEmpty()) { // 가장 빠른 시간 찾으면 같은 레벨 전부 탐색
			cnt_pop++;
			if (cnt_temp == cnt_pop) break;
			int cur = q.poll();
			if (cur == K) answer++;
		}
		System.out.println(level);
		System.out.println(answer);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		BFS(N);
	}
}
