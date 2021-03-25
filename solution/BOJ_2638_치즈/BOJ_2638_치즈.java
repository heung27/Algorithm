import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2638_치즈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map;
	static int[][] check;
	static int N, M;
	static int cnt, answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		check = new int[N][M];
		
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) cnt++;
			}
		}
		
		while (cnt > 0) {
			BFS();
			remove();
			answer++;
		}
		
		System.out.println(answer);
	}
	
	static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		map[0][0] = 2;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if (map[nx][ny] == 0) {
					queue.offer(new int[] {nx, ny});
					map[nx][ny] = 2;
				}
				else if (map[nx][ny] == 1) {
					check[nx][ny]++;
				}
			}
		}
	}
	
	static void remove() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 1) {
					if (check[i][j] >= 2) {
						map[i][j] = 0;
						cnt--;
					}
					check[i][j] = 0;
				}
				else if (map[i][j] == 2) map[i][j] = 0;
			}
		}
	}
}
