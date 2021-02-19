import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의_개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] movey = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[][] map;
	static boolean[][] check;
	static int W, H, cnt;
	
	public static void main(String[] args) throws IOException {
		while (true) {
			String[] str = br.readLine().split(" ");
			W = Integer.parseInt(str[0]);
			H = Integer.parseInt(str[1]);
			if (W == 0 && H == 0) break;
			map = new int[H][W];
			check = new boolean[H][W];
			cnt = 0;
			
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (!check[i][j] && map[i][j] == 1) {
						BFS(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		check[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int i=0; i<8; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				
				if (!check[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new int[] {nx, ny});
					check[nx][ny] = true;
				}
			}
		}
	}
}
