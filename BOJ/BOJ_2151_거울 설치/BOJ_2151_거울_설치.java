import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2151_거울_설치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][][] visit;
	static char[][] mat;
	static int N, answer;
	
	static int[] start, end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visit = new int[N][N][4];
		mat = new char[N][N];
		start = new int[2];
		end = new int[2];
		
		boolean check = false;
		for (int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				mat[i][j] = temp[j];
				if (mat[i][j] == '#') {
					if (!check) {
						start[0] = i;
						start[1] = j;
						check = true;
					} else {
						end[0] = i;
						end[1] = j;
					}
				}
			}
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0], start[1], 0});
		queue.offer(new int[] {start[0], start[1], 1});
		queue.offer(new int[] {start[0], start[1], 2});
		queue.offer(new int[] {start[0], start[1], 3});
		visit[start[0]][start[1]][0] = visit[start[0]][start[1]][1] = visit[start[0]][start[1]][2] = visit[start[0]][start[1]][3] = 1;
		mat[start[0]][start[1]] = '*';
		
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				
				int d = (pos[2]+1) % 4;
				for (int i=0; i<2; i++) {
					int nx = pos[0] + movex[d];
					int ny = pos[1] + movey[d];
					
					while (true) {
						if (nx < 0 || nx >= N || ny < 0 || ny >= N || mat[nx][ny] == '*') break;
						
						if (mat[nx][ny] == '!') {
							if (visit[nx][ny][d] != cnt) {
								queue.offer(new int[] {nx, ny, d});
								visit[nx][ny][d] = cnt;
							}
						} else if (mat[nx][ny] == '#') {
							return cnt-1;
						}
						
						nx += movex[d];
						ny += movey[d];
					}
					d = (d + 2) % 4;
				}
			}
			cnt++;
		}
		
		return -1;
	}
}
