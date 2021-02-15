import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서_연결하기 {
	static ArrayList<int[]> core;
	static int[] dirX = {-1, 1, 0, 0}; // 상하좌우
	static int[] dirY = {0, 0, -1, 1};
	static int[][] map;
	static int N, core_max, len_min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t=1; t<=tc; t++) {
			core = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=1; i<N-1; i++) {
				for (int j=1; j<N-1; j++) {
					if (map[i][j] == 1) core.add(new int[] {i, j});
				}
			}
			
			len_min = Integer.MAX_VALUE;
			core_max = 0;
			
			DFS(0, 0, 0);
			
			System.out.println("#"+t+" "+len_min);
		}
	}
	
	static void DFS(int sum, int index, int core_cnt) {
		if (index == core.size()) {
			if (core_max < core_cnt) {
				core_max = core_cnt;
				len_min = sum;
			}
			else if (core_max == core_cnt) {
				len_min = Math.min(len_min, sum);
			}
			return;
		}
		
		int[] pos = core.get(index);
			
		for (int k=0; k<4; k++) {
			int cnt = 0;
			int nextX = pos[0], nextY = pos[1];
			while (true) {
				nextX += dirX[k];
				nextY += dirY[k];
				
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
					while (true) {
						nextX -= dirX[k];
						nextY -= dirY[k];
						if (nextX == pos[0] && nextY == pos[1]) break;
						map[nextX][nextY] = 1;
					}
					
					DFS(sum+cnt, index+1, core_cnt+1);
					
					while (true) {
						nextX += dirX[k];
						nextY += dirY[k];
						if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) break;
						map[nextX][nextY] = 0;
					}
					break;
				}
				
				if (map[nextX][nextY] == 1) break;
				cnt++;
			}
		}
		DFS(sum, index+1, core_cnt);
	}
}
