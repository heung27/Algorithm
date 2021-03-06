import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지_안녕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][] map;
	static int[][] temp;
	static int[] machine;
	static int R, C, T;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		T = Integer.parseInt(str[2]);
		map = new int[R][C];
		temp = new int[R][C];
		machine = new int[2];
		
		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<R; i++) {
			if (map[i][0] == -1) {
				machine[0] = i;
				machine[1] = i+1;
				break;
			}
		}
		
		while (T-- > 0) {
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					if (map[i][j] != 0 && map[i][j] != -1) {
						spread(i, j);
					}
				}
			}
			
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					map[i][j] += temp[i][j];
					temp[i][j] = 0;
				}
			}
			
			run(0);
			run(1);
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				answer += map[i][j];
			}
		}
		System.out.println(answer + 2);
	}
	
	static void spread(int x, int y) {
		int add = map[x][y] / 5;
		
		if (add == 0) return;
		
		for (int d=0; d<4; d++) {
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;
			
			temp[nx][ny] += add;
			map[x][y] -= add;
		}
	}
	
	static void run(int pos) {
		int d, dir;
		if (pos == 0) {
			d = 0;
			dir = 1;
		}
		else {
			d = 2;
			dir = -1;
		}
		
		int x = machine[pos] + movex[d], y = movey[d];
		int check = machine[pos] - movex[d];
		
		while (true) {
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || nx == check) {
				d = (d + dir + 4) % 4;
				continue;
			}
			
			if (nx == machine[pos] && ny == 0) {
				map[x][y] = 0;
				break;
			}
			
			map[x][y] = map[nx][ny];
			x = nx; y = ny;
		}
	}
}
