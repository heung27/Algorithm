package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;

class Pair { // 페어 클래스 생성
//	private int first;
//	private int second;
	public int first;
	public int second;
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
//	public int getFirst() {
//		return first;
//	}
//	public int getSecond() {
//		return second;
//	}
}

public class BOJ_2468 {
	
	public static int[][] area;
	public static boolean[][] check;
	public static int[] diretion_x = {0, 1, 0, -1};
	public static int[] diretion_y = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		area = new int[num+2][num+2];
		TreeSet<Integer> set = new TreeSet<>(); // 중복이 불가능하고 정렬되는 set
		
		StringTokenizer st;
		for (int i=1; i<num+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<num+1; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				set.add(area[i][j]);
			}
		}
		int answer = 0;
		set.add(set.first()-1);
		for (Iterator<Integer> iter = set.iterator(); iter.hasNext(); ) { // 반복자
			check = new boolean[num+2][num+2];
			int sol = solution(num, iter.next());
			if (answer < sol) answer = sol;
		}
		System.out.println(answer);
		br.close();
	}
	
	public static int solution(int num, int rain) { // 연습용 DFS
		Stack<Pair> s = new Stack<>();
		int cnt = 0;
		for (int i=1; i<num+1; i++) {
			for (int j=1; j<num+1; j++) {
				if (!check[i][j] && area[i][j] > rain) {
					cnt++;
					s.push(new Pair(i, j));
					while (!s.empty()) {
						int x = s.peek().first;
						int y = s.peek().second;
						s.pop();
						check[x][y] = true;
						for (int k=0; k<4; k++) {
							int dir_x = x + diretion_x[k];
							int dir_y = y + diretion_y[k];
							if (!check[dir_x][dir_y] && area[dir_x][dir_y] > rain) {
								s.push(new Pair(dir_x, dir_y));
							}
						}
					}
				}
			}
		}
		return cnt;
	}
}
