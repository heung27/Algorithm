import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20057_마법사_상어와_토네이도 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] movex = {0, 1, 0, -1};
	static int[] movey = {-1, 0, 1, 0};
	
	static int[][] map;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move();
		
		System.out.println(answer);
	}
	
	static void move() {
		int x = N/2, y = N/2;
		int d = 0, cnt = 1, m = 0;
		boolean t = false;
		
		while (x != 0 || y != 0) {
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (map[nx][ny] != 0) spread(nx, ny, d);
			
			if (++m == cnt) {
				m = 0;
				d = (d + 5) % 4;
				if (!t) t = true;
				else {
					t = false;
					cnt++;
				}
			}
			x = nx; y = ny;
		}
	}
	
	static void spread(int x, int y, int d) {
		int[] per = {5, 2, 10, 7, 1, 2, 10, 7, 1, 100};
		int[] nx = new int[10];
		int[] ny = new int[10];
		
		int cur = map[x][y], sum = 0;
		int left = (d + 1) % 4;
		
		int index = 0;
		nx[index] = x + movex[d] * 2;
		ny[index++] = y + movey[d] * 2;
		for (int flag = 1; flag >= -1; flag -= 2) {
			int mx = movex[left] * flag;
			int my = movey[left] * flag;
			
			nx[index] = x + mx * 2;
			ny[index++] = y + my * 2;
			
			for (int k = 1; k >= -1; k--) {
				nx[index] = x + mx + movex[d] * k;
				ny[index++] = y + my + movey[d] * k;
			}
		}
		nx[index] = x + movex[d];
		ny[index] = y + movey[d];
		
		for (int i=0; i<10; i++) {
			if (i == 9) cur -= sum;
			
			int num = cur * per[i] / 100;
			
			if (num == 0) continue;
			if (nx[i] < 0 || nx[i] >= N || ny[i] < 0 || ny[i] >= N) {
				answer += num;
			}
			else {
				map[nx[i]][ny[i]] += num;
			}
			sum += num;
		}
		map[x][y] = 0;
	}
}
