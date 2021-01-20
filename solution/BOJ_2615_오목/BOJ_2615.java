package Baekjoon;

import java.util.Scanner;

public class BOJ_2615 {
	static final int SIZE = 19;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] map = new String[SIZE][SIZE];
		
		for (int i=0; i<SIZE; i++) {
			map[i] = sc.nextLine().split(" ");
		}
		int i=0, j=0;
		a: for (i=0 ; i<SIZE; i++) {
			for (j=0 ; j<SIZE; j++) {
				if (!map[i][j].equals("0") &&  solution(map, i, j)) break a;
			}
		}
		if (i==SIZE && j==SIZE) System.out.println("0");
		sc.close();
	}
	
	static boolean solution(String[][] map, int x, int y) {
		String current = map[x][y];
		int cnt_right = 1, cnt_down = 1, cnt_right_diagonal = 1, cnt_left_diagonal = 1;
		
		if (y-1 < 0 || !map[x][y-1].equals(current)) {
			for (int i=1; y+i<SIZE; i++) { // 오른쪽
				if (map[x][y+i].equals(current)) cnt_right++;
				else break;
			}
			if (cnt_right == 5) {
				System.out.println(current);
				System.out.println((x+1)+" "+(y+1));
				return true;
			}
		}
		
		if ((y-1 < 0 || x-1 < 0) || !map[x-1][y-1].equals(current)) {
			for (int i=1; y+i<SIZE&&x+i<SIZE; i++) { // 대각선 오른쪽
				if (map[x+i][y+i].equals(current)) cnt_right_diagonal++;
				else break;
			}
			if (cnt_right_diagonal == 5) {
				System.out.println(current);
				System.out.println((x+1)+" "+(y+1));
				return true;
			}
		}
		
		if (x-1 < 0 || !map[x-1][y].equals(current)) { 
			for (int i=1; x+i<SIZE; i++) { // 아래
				if (map[x+i][y].equals(current)) cnt_down++;
				else break;
			}
			if (cnt_down == 5) {
				System.out.println(current);
				System.out.println((x+1)+" "+(y+1));
				return true;
			}
		}
		
		if ((y+1 >= SIZE || x-1 < 0) || !map[x-1][y+1].equals(current)) {
			for (int i=1; y-i>=0&&x+i<SIZE; i++) { // 대각선 왼쪽
				if (map[x+i][y-i].equals(current)) cnt_left_diagonal++;
				else break;
			}
			if (cnt_left_diagonal == 5) {
				System.out.println(current);
				System.out.println((x+5)+" "+(y-3));
				return true;
			}
		}
		
		return false;
	}
}
