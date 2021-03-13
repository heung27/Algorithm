import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_20056_마법사_상어와_파이어볼 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> temp = new LinkedList<>();
	
	static int[] movex = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] movey = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int[][][] map;
	static int[][] cnt;
	static int N, M, K;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		map = new int[N][N][3];
		cnt = new int[N][N];
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0]) - 1;
			int c = Integer.parseInt(str[1]) - 1;
			map[r][c][0] = Integer.parseInt(str[2]); // 질량
			map[r][c][1] = Integer.parseInt(str[3]); // 속도
			map[r][c][2]  = Integer.parseInt(str[4]); // 방향
			
			cnt[r][c] = 1;
			queue.offer(new int[] {r, c});
		}
		
		while (K-- > 0) {
			move();
			init();
		}
		
		int answer = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (cnt[i][j] == 0) continue;
				else if (cnt[i][j] == 1) answer += map[i][j][0];
				else answer += (map[i][j][0] / 5) * 4;
			}
		}
		System.out.println(answer);
	}
	
	static void move() {
		int size = queue.size();
		while (size-- > 0) {
			int[] pos = queue.poll();
			int i = pos[0], j = pos[1];
			
			int m = map[i][j][0], s = map[i][j][1], d = map[i][j][2];
			
			if (cnt[i][j] == 1) {
				fly(i, j, m, s, d);
			}
			else {
				m /= 5; s /= cnt[i][j];
				if (m != 0) {
					int dir = -1;
					if (d == 0 || d == cnt[i][j]) dir = 0;
					else dir = 1;
					
					for ( ; dir < 8; dir += 2) {
						fly(i, j, m, s, dir);
					}
				}
			}
			
			for (int k=0; k<3; k++) {
				map[i][j][k] = 0;
			}
			cnt[i][j] = 0;
		}
	}
	
	static void fly(int i, int j, int m, int s, int d) {
		int nx = (i + movex[d] * (s % N) + N ) % N;
		int ny = (j + movey[d] * (s % N) + N ) % N;
		
		temp.offer(new int[] {nx, ny, m, s, d});
	}
	
	static void init() {
		while (!temp.isEmpty()) {
			int[] pos = temp.poll();
			int i = pos[0], j = pos[1];
			map[i][j][0] += pos[2];
			map[i][j][1] += pos[3];
			cnt[i][j]++;
			
			if (cnt[i][j] == 1) {
				queue.offer(new int[] {i, j});
				map[i][j][2] = pos[4];
			}
			else if (cnt[i][j] == 2) {
				map[i][j][2] = map[i][j][2]%2 + pos[4]%2;
			}
			else map[i][j][2] += pos[4]%2;
		}
	}
}
