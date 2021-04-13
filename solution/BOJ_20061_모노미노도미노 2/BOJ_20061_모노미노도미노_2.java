import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_20061_모노미노도미노_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean[][] blue = new boolean[4][10];
	static boolean[][] green = new boolean[4][10];
	static int[] blue_cnt = new int[10];
	static int[] green_cnt = new int[10];
	static int N, score;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			int t = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			int y = Integer.parseInt(str[2]);
			
			if (t == 1) {
				int[][] pos = {{x, y}};
				func(pos);
			}
			else if (t == 2) {
				int[][] pos = {{x, y}, {x, y+1}};
				func(pos);
			}
			else {
				int[][] pos = {{x, y}, {x+1, y}};
				func(pos);
			}
		}
		
		int sum = 0;
		for (int j=6; j<10; j++) {
			sum += blue_cnt[j];
			sum += green_cnt[j];
		}
		
		System.out.println(score+"\n"+sum);
	}
	
	static void func(int[][] pos) {
		move(blue, blue_cnt, pos);
		check(blue, blue_cnt);
		
		for (int i=0; i<pos.length; i++) {
			int temp = pos[i][0];
			pos[i][0] = 3 - pos[i][1];
			pos[i][1] = temp;
		}
		
		move(green, green_cnt, pos);
		check(green, green_cnt);
	}
	
	static void move(boolean[][] color, int[] cnt, int[][] pos) {
		int min = 9;
		for (int k=0; k<pos.length; k++) {
			int x = pos[k][0];
			int y = pos[k][1];
			
			for (int j=y+1; j<10; j++) {
				if (color[x][j]) {
					min = Math.min(min, j-y-1);
					break;
				}
				if (j == 9) {
					min = Math.min(min, j-y);
				}
			}
		}
		
		for (int k=0; k<pos.length; k++) {
			int x = pos[k][0];
			int y = pos[k][1];
			
			color[x][y+min] = true;
			cnt[y+min]++;
		}
		
		remove(color, cnt);
	}
	
	static void remove(boolean[][] color, int[] cnt) {
		for (int j=9; j>5; ) {
			if (cnt[j] == 4) {
				score++;
				for (int k=j; k>=4; k--) {
					for (int i=0; i<4; i++) {
						color[i][k] = color[i][k-1];
					}
					cnt[k] = cnt[k-1];
				}
			}
			else j--;
		}
	}
	
	static void check(boolean[][] color, int[] cnt) {
		if (cnt[4] != 0 && cnt[5] != 0) {
			down(color, cnt, 7);
		}
		else if (cnt[4] != 0 || cnt[5] != 0) {
			down(color, cnt, 8);
		}
	}
	
	static void down(boolean[][] color, int[] cnt, int start) {
		int index = 9;
		for (int k=start; k>=4; k--, index--) {
			for (int i=0; i<4; i++) {
				color[i][index] = color[i][k];
				color[i][k] = false;
			}
			cnt[index] = cnt[k];
			cnt[k] = 0;
		}
	}
}
