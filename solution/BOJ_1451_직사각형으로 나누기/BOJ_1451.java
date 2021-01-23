package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1451 {
	public static int[][] map;
	public static long[][] prefix_sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		prefix_sum = new long[n+1][m+1];
		for (int i=0; i<n; i++) {
			String str = br.readLine();
			for (int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		} // 입력
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<m+1; j++) {
				prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1] + map[i-1][j-1];
			}
		} // 누적 합 세팅
		
		System.out.println(solution(n, m));
		br.close();
	}
	
	public static long partial_sum(int x1, int y1, int x2, int y2) {
		long left_sum = prefix_sum[x2][y1-1]; // 왼쪽 누적 합
		long upper_sum = prefix_sum[x1-1][y2]; // 위쪽 누적 합
		long previous_sum = prefix_sum[x1-1][y1-1]; // 왼쪽 대각선 위 누적 합
		return prefix_sum[x2][y2] - left_sum - upper_sum + previous_sum; // 부분 합 계산
	}
	
	public static long solution(int n, int m) {
		long part1, part2, part3;
		long max = 0, mul;
		for (int i=1; i<m-1; i++) { // case 1: |||
			for (int j=i+1; j<m; j++) {
				part1 = partial_sum(1, 1, n, i);
				part2 = partial_sum(1, i+1, n, j);
				part3 = partial_sum(1, j+1, n, m);
				mul = part1 * part2 * part3;
				if (max < mul) max = mul;
			}
		}
		for (int i=1; i<n-1; i++) { // case 2: ㅡㅡㅡ
			for (int j=i+1; j<n; j++) {
				part1 = partial_sum(1, 1, i, m);
				part2 = partial_sum(i+1, 1, j, m);
				part3 = partial_sum(j+1, 1, n, m);
				mul = part1 * part2 * part3;
				if (max < mul) max = mul;
			}
		}
		for (int i=1; i<n; i++) { // case 3: case 4: case 5: case 6:
			for (int j=1; j<m; j++) {
				part1 = partial_sum(1, 1, i, m);
				part2 = partial_sum(i+1, 1, n, j);
				part3 = partial_sum(i+1, j+1, n, m);
				mul = part1 * part2 * part3;
				if (max < mul) max = mul;
				
				part1 = partial_sum(1, 1, i, j);
				part2 = partial_sum(1, j+1, i, m);
				part3 = partial_sum(i+1, 1, n, m);
				mul = part1 * part2 * part3;
				if (max < mul) max = mul;
				
				part1 = partial_sum(1, 1, i, j);
				part2 = partial_sum(i+1, 1, n, j);
				part3 = partial_sum(1, j+1, n, m);
				mul = part1 * part2 * part3;
				if (max < mul) max = mul;
				
				part1 = partial_sum(1, 1, n, j);
				part2 = partial_sum(1, j+1, i, m);
				part3 = partial_sum(i+1, j+1, n, m);
				mul = part1 * part2 * part3;
				if (max < mul) max = mul;
			}
		}
		return max;
	}
}
