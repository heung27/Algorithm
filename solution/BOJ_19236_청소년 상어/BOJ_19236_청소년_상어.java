import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_19236_청소년_상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Fish {
		int x, y;
		int d;
		
		public Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static int[] movex = {-1, -1, 0, 1, 1, 1, 0, -1}; // 위쪽부터 반시계 방향
	static int[] movey = {0, -1, -1, -1, 0, 1, 1, 1};
	
	static Fish[] fish_arr = new Fish[17];
	
	static int[][] map = new int[4][4];
	static int[] shark = new int[3];
	static int answer;
	
	public static void main(String[] args) throws IOException {
		for (int i=0; i<4; i++) {
			String[] str = br.readLine().split(" ");
			for (int j=0; j<8; j+=2) {
				int num = Integer.parseInt(str[j]);
				int d = Integer.parseInt(str[j+1])-1;
				fish_arr[num] = new Fish(i, j/2, d);
				map[i][j/2] = num;
			}
		}
		
		Fish f = fish_arr[map[0][0]];
		shark[2] = f.d;
		f.d = -1;
		
		int num = map[0][0];
		map[0][0] = 0;
		
		move_shark(map, fish_arr, shark, num);
		
		System.out.println(answer);
	}
	
	static void move_fish(int[][] map, Fish[] arr, int[] shark) {
		for (int i=1; i<=16; i++) {
			if (arr[i].d == -1) continue;
			
			Fish fish = arr[i];
			int dir = fish.d;
			
			for (int k=0; k<8; k++, dir=(dir+1)%8) {
				int nx = fish.x + movex[dir];
				int ny = fish.y + movey[dir];
				
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
				
				if (nx != shark[0] || ny != shark[1]) {
					int temp = map[nx][ny];
					map[nx][ny] = map[fish.x][fish.y];
					map[fish.x][fish.y] = temp;
						
					if (temp != 0) {
						arr[temp].x = fish.x;
						arr[temp].y = fish.y;
					}
					
					fish.x = nx;
					fish.y = ny;
					fish.d = dir;
					break;
				}
			}
		}
	}
	
	static void move_shark(int[][] map, Fish[] arr, int[] shark, int sum) {
		move_fish(map, arr, shark);
		
		int nx = shark[0], ny = shark[1];
		while (true) {
			nx += movex[shark[2]];
			ny += movey[shark[2]];
			
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
			
			if (map[nx][ny] != 0) {
				int nd = arr[map[nx][ny]].d;
				int num = map[nx][ny];
				
				arr[map[nx][ny]].d = -1;
				map[nx][ny] = 0;
				
				int[][] temp_map = copy_map(map);
				Fish[] temp_arr = copy_arr(arr);
				
				move_shark(temp_map, temp_arr, new int[] {nx, ny, nd}, sum + num);
				
				map[nx][ny] = num;
				arr[map[nx][ny]].d = nd;
			}
		}
		
		if (answer < sum) answer = sum;
	}
	
	static int[][] copy_map(int[][] map) {
		int[][] temp_map = new int[4][4];
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				temp_map[i][j] = map[i][j];
			}
		}
		return temp_map;
	}
	
	static Fish[] copy_arr(Fish[] arr) {
		Fish[] temp_arr = new Fish[17];
		for (int i=1; i<17; i++) {
			temp_arr[i] = new Fish(arr[i].x, arr[i].y, arr[i].d);
		}
		return temp_arr;
	}
}
