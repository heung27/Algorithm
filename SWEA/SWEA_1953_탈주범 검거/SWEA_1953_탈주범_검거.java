import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범_검거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][][] map;
	static boolean[][] check;
	static int N, M, R, C, L;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M][];
			check = new boolean[N][M];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					int x = Integer.parseInt(st.nextToken());
					int[] dir = null;
					
					switch (x) {
					case 1: dir = new int[] {1, 1, 1, 1}; break;
					case 2: dir = new int[] {1, 0, 1, 0}; break;
					case 3: dir = new int[] {0, 1, 0, 1}; break;
					case 4: dir = new int[] {1, 1, 0, 0}; break;
					case 5: dir = new int[] {0, 1, 1, 0}; break;
					case 6: dir = new int[] {0, 0, 1, 1}; break;
					case 7: dir = new int[] {1, 0, 0, 1}; break;
					}
					
					map[i][j] = dir;
				}
			}
			sb.append("#").append(t).append(" ").append(BFS()).append("\n");
		}
		bw.write(sb.toString());;
		bw.flush();
	}
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {R, C});
		check[R][C] = true;
		int depth = 0, cnt = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				cnt++;
				
				for (int d=0; d<4; d++) {
					if (map[pos[0]][pos[1]][d] == 0) continue;
					
					int nx = pos[0] + movex[d];
					int ny = pos[1] + movey[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || check[nx][ny] || map[nx][ny] == null) continue;
					
					if (map[nx][ny][(d + 2) % 4] == 0) continue;
					
					queue.offer(new int[] {nx, ny});
					check[nx][ny] = true;
				}
			}
			depth++;
			if (depth == L) break;
		}
		return cnt;
	}
}
