import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1868_파핑파핑_지뢰찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] movey = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int[][] check;
	static char[][] map;
	static int N, bcnt, cnt0;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			check = new int[N][N];
			bcnt = cnt0 = 0;
			
			for (int i=0; i<N; i++) {
				String s = br.readLine();
				for (int j=0; j<N; j++) {
					map[i][j] = s.charAt(j);
					
					if (map[i][j] == '*') {
						bcnt++;
						for (int d=0; d<8; d++) {
							int nx = i + movex[d];
							int ny = j + movey[d];
							
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							
							check[nx][ny]++;
						}
					}
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == '.' && check[i][j] == 0) {
						cnt0++;
						BFS(i, j);
					}
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(N*N - bcnt + cnt0).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		map[x][y] = '0';
		bcnt++;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int d=0; d<8; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == '*') continue;
				
				if (check[nx][ny] == 0) {
					if (map[nx][ny] == '.') {
						queue.offer(new int[] {nx, ny});
						map[nx][ny] = (char)(check[nx][ny] + 48);
						bcnt++;
					}
				}
				else {
					if (map[nx][ny] == '.') {
						map[nx][ny] = (char)(check[nx][ny] + 48);
						bcnt++;
					}
				}
			}
		}
	}
}