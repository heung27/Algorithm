import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static boolean[][] check;
	static int[][] map;
	static int N, M;
	static int cnt, answer, temp;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		check = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
				 if (map[i][j] == 1) cnt++;
			}
		}
		
		while (cnt > 0) {
			temp = cnt;
			BFS();
			init();
			answer++;
		}
		
		sb.append(answer).append("\n");
		sb.append(temp).append("\n");
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void BFS() {
		int cheeze = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		check[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int i=0; i<4; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if (!check[nx][ny]) {
					if (map[nx][ny] == 1) {
						map[nx][ny] = 0;
						cheeze++;
					}
					else queue.offer(new int[] {nx,ny});
					
					check[nx][ny] = true;
				}
			}
		}
		cnt -= cheeze;
	}
	
	static void init() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				check[i][j] = false;
			}
		}
	}
}
