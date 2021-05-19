import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1194_달이_차오른다_가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[] start = new int[2];
	
	static char[][] map;
	static boolean[][][] check;
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new char[N][M];
		check = new boolean[N][M][1<<6];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				
				if (map[i][j] == '0') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0], start[1], 0});
		check[start[0]][start[1]][0] = true;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				
				if (map[pos[0]][pos[1]] == '1') return cnt;
				
				for (int d=0; d<4; d++) {
					int nx = pos[0] + movex[d];
					int ny = pos[1] + movey[d];
					int flag = pos[2];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#') continue;
					
					if (!check[nx][ny][flag]) {
						if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
							if ((flag & (1 << map[nx][ny]-'a')) == 0) continue;
						}
						else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
							flag |= (1 << map[nx][ny]-'a');
						}
						
						queue.offer(new int[] {nx, ny, flag});
						check[nx][ny][flag] = true;
					}
				}
			}
			cnt++;
		}
		
		return -1;
	}
}
