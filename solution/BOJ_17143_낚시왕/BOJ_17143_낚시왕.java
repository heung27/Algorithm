import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17143_낚시왕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Shark {
		int num; // 번호
		int x, y; // 좌표
		int s; // 속력
		int d; // 방향
		int size; // 크기
		
		public Shark(int num, int x, int y, int s, int d, int size) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.size = size;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, 1, -1};
	
	static int[][] map;
	static Shark[] arr;
	static int R, C, M;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		M = Integer.parseInt(str[2]);
		
		map = new int[R+1][C+1];
		arr = new Shark[M+1];
		
		int[] in = new int[5];
		for (int i=1; i<=M; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<5; j++) {
				in[j] = Integer.parseInt(str[j]);
			}
			map[in[0]][in[1]] = i;
			
			if (in[3] <= 2) in[2] %= (R-1)<<1;
			else in[2] %= (C-1)<<1;
			
			arr[i] = new Shark(i, in[0], in[1], in[2], in[3]-1, in[4]);
		}
		
		for (int j=1; j<=C; j++) {
			getShark(j);
		}
			
		System.out.println(answer);
	}
	
	static void getShark(int j) {
		for (int i=1; i<=R; i++) {
			if (map[i][j] != 0) {
				int num = map[i][j];
				answer += arr[num].size;
				
				map[i][j] = 0;
				arr[num] = null;
				break;
			}
		}
		move();
	}
	
	static void move() {
		int[][] temp = new int[R+1][C+1];
		
		for (int i=1; i<=M; i++) {
			if (arr[i] == null) continue;
			
			Shark shark = arr[i];
			
			int d = shark.d;
			int nx = shark.x, ny = shark.y;
			for (int j=0; j<shark.s; j++) {
				if (d == 0 && nx == 1) d = 1;
				else if (d == 1 && nx == R) d = 0;
				else if (d == 2 && ny == C) d = 3;
				else if (d == 3 && ny == 1) d = 2;
				
				nx += movex[d];
				ny += movey[d];
			}
			
			if (temp[nx][ny] == 0) {
				temp[nx][ny] = shark.num;
			}
			else {
				if (arr[temp[nx][ny]].size < shark.size) {
					arr[temp[nx][ny]] = null;
					temp[nx][ny] = shark.num;
				}
				else arr[shark.num] = null;
			}
			shark.x = nx;
			shark.y = ny;
			shark.d = d;
		}
		map = temp;
	}
}
