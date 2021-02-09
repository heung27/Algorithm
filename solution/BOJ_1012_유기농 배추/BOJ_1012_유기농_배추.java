import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1012_유기농_배추 {
	static boolean[][] map;
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};
	static int X, Y, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			String[] str = br.readLine().split(" ");
			X = Integer.parseInt(str[0]);
			Y = Integer.parseInt(str[1]);
			map = new boolean[X][Y];
			
			K = Integer.parseInt(str[2]);
			while (K-- > 0) {
				str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				map[x][y] = true;
			}
			
			int cnt = 0;
			for (int i=0; i<X; i++) {
				for (int j=0; j<Y; j++) {
					if (map[i][j]) {
						cnt++;
						BFS(i, j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		map[x][y] = false;
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int i=0; i<4; i++) {
				int nextX = pos[0] + moveX[i];
				int nextY = pos[1] + moveY[i];
				if (nextX >= 0 && nextX < X && nextY >= 0 && nextY < Y && map[nextX][nextY]) {
					queue.add(new int[] {nextX, nextY});
					map[nextX][nextY] = false;
				}
			}
		}
	}
}
