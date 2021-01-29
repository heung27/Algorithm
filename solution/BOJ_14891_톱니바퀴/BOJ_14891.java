package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_14891 {
	public static int[][] gear = new int[4][8];
	public static int[][] point = new int[4][2];
	
	public static int isNum (int num) {
		if (num < 0) return 7;
		else return num;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<4; i++) {
			String str = br.readLine();
			for (int j=0; j<8; j++) {
				gear[i][j] = str.charAt(j)-'0';
			}
			point[i][0] = 6; // 왼쪽 바퀴와 닿는 자리
			point[i][1] = 2; // 오른쪽 바퀴와 닿는 자리
		}
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			String[] act = br.readLine().split(" ");
			int number = Integer.parseInt(act[0])-1;
			int direction = Integer.parseInt(act[1]);
			int left = gear[number][point[number][0]];
			int right = gear[number][point[number][1]];
			
			// 왼쪽 바퀴
			int temp_direction = direction;
			int pre = number - 1;
			while (pre >= 0) {
				if (gear[pre][point[pre][1]] != left) {
					left = gear[pre][point[pre][0]];
					point[pre][0] = isNum(point[pre][0] + temp_direction) % 8;
					point[pre][1] = isNum(point[pre][1] + temp_direction) % 8;
					temp_direction = -temp_direction;
				}
				else break;
				pre--;
			}
			
			// 오른쪽 바퀴
			temp_direction = direction;
			int post = number + 1;
			while (post < 4) {
				if (gear[post][point[post][0]] != right) {
					right = gear[post][point[post][1]];
					point[post][0] = isNum(point[post][0] + temp_direction) % 8;
					point[post][1] = isNum(point[post][1] + temp_direction) % 8;
					temp_direction = -temp_direction;
				}
				else break;
				post++;
			}
			
			// 현재 바퀴
			point[number][0] = isNum(point[number][0] - direction) % 8;
			point[number][1] = isNum(point[number][1] - direction) % 8;
		}
		int sum = 0;
		for (int i=0; i<4; i++) {
			int pos = (point[i][0] + 2) % 8;
			if (gear[i][pos] == 1) sum += (int)Math.pow(2, i);
		}
		System.out.println(sum);
	}
}
