import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_19237_어른_상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] movex = {-1, 1, 0, 0}; // 상하좌우
	static int[] movey = {0, 0, -1, 1};
	
	static int[][][] map, priority;
	static int[][] shark_pos;
	static boolean[][] check;
	static int[] dir; 
	static int N, M, K;
	static int num;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		priority = new int[M+1][4][4];
		map = new int[N][N][2];
		shark_pos = new int[M+1][2]; // 상어의 현재 위치
		check = new boolean[N][N];
		dir = new int[M+1]; // 상어의 방향
		num = M;
		
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				map[i][j][0] = Integer.parseInt(str[j]);
				if (map[i][j][0] != 0) {
					shark_pos[map[i][j][0]] = new int[] {i, j};
					map[i][j][1] = K;
				}
			}
		}
		
		str = br.readLine().split(" ");
		for (int i=1; i<=M; i++) {
			dir[i] = Integer.parseInt(str[i-1])-1;
		}
		
		for (int i=1; i<=M; i++) {
			for (int j=0; j<4; j++) { // 0: 위, 1: 아래, 2: 왼, 3: 오른
				str = br.readLine().split(" ");
				for (int k=0; k<4; k++) {
					// [상어 번호][방향][우선순위]
					priority[i][j][k] = Integer.parseInt(str[k])-1;
				}
			}
		}
		
		int answer = 0;
		while (++answer <= 1000) {
			move();
			if (num == 1) break;
			check_k();
		}
		if (answer > 1000) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static void move() {
		for (int i=1; i<=M; i++) {
			if (shark_pos[i] == null) continue;
			
			int[] pos = shark_pos[i];
			int d = dir[i];
			int[] back = null;
			
			int j = 0;
			for ( ; j<4; j++) {
				int dx = priority[i][d][j];
				int nx = pos[0] + movex[dx];
				int ny = pos[1] + movey[dx];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if (map[nx][ny][0] == 0) {
					if (!check[nx][ny]) { 
						shark_pos[i] = new int[] {nx, ny};
						dir[i] = dx;
						check[nx][ny] = true;
					}
					else { // 그 자리에 이미 상어가 있으면 상어 제거
						shark_pos[i] = null;
						num--;
					}
					break;
				}
				
				if (back == null && map[nx][ny][0] == i) {
					back = new int[] {nx, ny, dx};
				}
			}
			
			if (j == 4) { // 왔던 길로 돌아감
				shark_pos[i] = new int[] {back[0], back[1]};
				map[back[0]][back[1]] = new int[] {i, K+1};
				dir[i] = back[2];
			}
		}
	}
	
	static void check_k() {
		for (int i=1; i<=M; i++) { // 상어들 위치 표시
			if (shark_pos[i] == null) continue;
			
			int[] pos = shark_pos[i];
			map[pos[0]][pos[1]] = new int[] {i, K+1};
			check[pos[0]][pos[1]] = false;
		}
		
		for (int i=0; i<N; i++) { // 시간 카운트
			for (int j=0; j<N; j++) {
				if (map[i][j][0] != 0) {
					if (--map[i][j][1] == 0) map[i][j][0] = 0;
				}
			}
		}
	}
}
