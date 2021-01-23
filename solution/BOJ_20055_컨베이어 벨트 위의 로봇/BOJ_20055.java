package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_20055 {
	public static int[] area;
	public static boolean[] check;
	public static int cnt;
	
	public static void beltMove(int size, int n) {
		int temp = area[size-1];
		boolean temp_check = check[size-1];
		for (int i=size-1; i>0; i--) {
			area[i] = area[i-1];
			check[i] = check[i-1];
		}
		area[0] = temp;
		check[0] = temp_check;
		check[n-1] = false; // 회전했는데 내려가는 자리면 제거
	}
	
	public static void robotMove(int n) {
		for (int i=n-2; i>=0; i--) {
			if (check[i]) {
				if (!check[i+1] && area[i+1] > 0) {
					check[i] = false;
					check[i+1] = true;
					if (--area[i+1] == 0) cnt++;
				}
			}
		}
		check[n-1] = false; // 이동했는데 내려가는 자리면 제거
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int size = 2*n;
		area = new int[size];
		check = new boolean[size];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<size; i++) {
			area[i] = Integer.parseInt(st.nextToken());
		}
		int level = 0;
		while (cnt < k) {
			level++;
			beltMove(size, n);
			robotMove(n);
			if (!check[0] && area[0] > 0) {
				check[0] = true;
				area[0]--;
				if (area[0] == 0) cnt++;
			}
		}
		System.out.println(level);
		br.close();
	}
}
