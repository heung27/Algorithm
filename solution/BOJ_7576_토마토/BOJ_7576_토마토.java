import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static Queue<int[]> queue = new LinkedList<>();
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	static int[][] map;
	static int N, M;
	static int cnt0, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) cnt0++;
				else if (map[i][j] == 1) {
					queue.offer(new int[] {i,j});
				}
			}
		}
		BFS();
		if (cnt0 > 0) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static void BFS() {
		while (!queue.isEmpty()) {
			if (cnt0 == 0) return;
			answer++;
			int size = queue.size();
			while (size-- > 0) {
				int[] pos = queue.poll();
				
				for (int i=0; i<4; i++) {
					int nx = pos[0] + movex[i];
					int ny = pos[1] + movey[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					if (map[nx][ny] == 0) {
						map[nx][ny] = 1;
						queue.offer(new int[] {nx,ny});
						cnt0--;
					}
				}
			}
		}
	}
}
