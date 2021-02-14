import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234_성곽 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] check;
	static int[][] map;
	static int[] size;
	static int N, M;
	
	static int room_cnt, room_area, max;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		map = new int[N][M];
		check = new int[N][M];
		size = new int[N*M+1];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (check[i][j] == 0) {
					room_cnt++;
					BFS(i, j);
				}
			}
		}
		
		int temp ;
		for (int i=0; i<N; i++) {
			temp = check[i][0];
			for (int j=1; j<M; j++) {
				if (temp != check[i][j]) {
					max = Math.max(max, size[temp] + size[check[i][j]]);
					temp = check[i][j];
				}
			}
		}
		
		for (int j=0; j<M; j++) {
			temp = check[0][j];
			for (int i=1; i<N; i++) {
				if (temp != check[i][j]) {
					max = Math.max(max, size[temp] + size[check[i][j]]);
					temp = check[i][j];
				}
			}
		}
		
		sb.append(room_cnt).append("\n");
		sb.append(room_area).append("\n");
		sb.append(max);
		
		System.out.println(sb);
	}
	
	static void BFS(int x, int y) {
		int[] dir_X = {0, -1, 0, 1}; // 서북동남
		int[] dir_Y = {-1, 0, 1, 0};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		check[x][y] = room_cnt;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int data = map[pos[0]][pos[1]];
			cnt++;
			
			for (int k=0; k<4; k++) {
				if (data % 2 == 0) {
					int nx = pos[0]+dir_X[k];
					int ny = pos[1]+dir_Y[k];
					if (check[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
						check[nx][ny] = room_cnt;
					}
				}
				data >>= 1;
			}
		}
		
		size[room_cnt] = cnt;
		room_area = Math.max(cnt, room_area);
	}
}
