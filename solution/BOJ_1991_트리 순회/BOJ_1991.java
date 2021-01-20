package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1991 {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		map = new int[num][2];
		for (int i=0; i<num; i++) {   
			String[] str = br.readLine().split(" ");
			int node = str[0].charAt(0)-'A';
			for (int j=0; j<2; j++) {
				char sub = str[j+1].charAt(0);
				if (sub != '.')
					map[node][j] = sub-'A';
				else map[node][j] = -1;
			}
		}
		pre(0);
		System.out.println();
		in(0);
		System.out.println();
		post(0);
		br.close();
	}
	
	 static void pre(int x) {
		 System.out.print((char)(x + 'A'));
		 if (map[x][0] > 0) pre(map[x][0]);
		 if (map[x][1] > 0) pre(map[x][1]);
	 }
	 
	 static void in(int x) {
		 if (map[x][0] > 0) in(map[x][0]);
		 System.out.print((char)(x + 'A'));
		 if (map[x][1] > 0) in(map[x][1]);
	 }
	 
	 static void post(int x) {
		 if (map[x][0] > 0) post(map[x][0]);
		 if (map[x][1] > 0) post(map[x][1]);
		 System.out.print((char)(x + 'A'));
	 }
}
 