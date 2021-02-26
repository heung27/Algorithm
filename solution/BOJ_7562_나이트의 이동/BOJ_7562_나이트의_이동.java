import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의_이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, -1, 1, 1};
	static int[] movey = {-1, 1, -1, 1};
	
	static boolean[][] check;
	static int[][] map;
	static int I, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			check = new boolean[I][I];
			answer = 0;
			
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			str = br.readLine().split(" ");
			int x2 = Integer.parseInt(str[0]);
			int y2 = Integer.parseInt(str[1]);
			
			BFS(x, y, x2, y2);
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void BFS(int x, int y, int x2, int y2) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		check[x][y] = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				
				if (pos[0] == x2 && pos[1] == y2) return;
				
				for (int i=0; i<4; i++) {
					int nx = pos[0] + movex[i];
					int ny = pos[1] + movey[i];
					
					int k = nx + movex[i];
					if (k >= 0 && k < I && ny >= 0 && ny < I) {
						if (!check[k][ny]) {
							queue.offer(new int[] {k, ny});
							check[k][ny] = true;
						}
					}
					
					k = ny + movey[i];
					if (nx >= 0 && nx < I && k >= 0 && k < I) {
						if (!check[nx][k]) {
							queue.offer(new int[] {nx, k});
							check[nx][k] = true;
						}
					}
				}
			}
			answer++;
		}
	}
}