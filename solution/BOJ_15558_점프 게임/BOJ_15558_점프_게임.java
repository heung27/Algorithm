import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_15558_점프_게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[][] num;
	static boolean[][] check;
	static int N, K, Y;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		num = new int[2][N];
		check = new boolean[2][N];
		
		for (int i=0; i<2; i++) {
			String s = br.readLine();
			for (int j=0; j<N; j++) {
				num[i][j] = s.charAt(j);
			}
		}
		
		if (BFS()) System.out.println(1);
		else System.out.println(0);
	}
	
	static boolean BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		check[0][0] = true;
		
		int nx, ny;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				int x = pos[0], y = pos[1];
				
				ny = y - 1;
				if (ny >= Y+1) {
					if (!check[x][ny] && num[x][ny] == 49) {
						queue.offer(new int[] {x, ny});
						check[x][ny] = true;
					}
				}
				
				ny = y + 1;
				if (ny >= N) return true;
				if (!check[x][ny] && num[x][ny] == 49) {
					queue.offer(new int[] {x, ny});
					check[x][ny] = true;
				}
				
				ny = y + K;
				if (ny >= N) return true;
				nx = (x + 1) % 2;
				if (!check[nx][ny] && num[nx][ny] == 49) {
					queue.offer(new int[] {nx, ny});
					check[nx][ny] = true;
				}
			}
			Y++;
		}
		return false;
	}
}
