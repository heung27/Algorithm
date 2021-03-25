import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9207_페그_솔리테어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static class Pin {
		int x, y;

		public Pin(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static char[][] map = new char[5][9];
	static int R = 5, C = 9;
	
	static Pin[] list = new Pin[9];
	static boolean[] check = new boolean[8];
	static int size, answer;
	
	public static void main(String[] args) throws IOException {
 		int test = Integer.parseInt(br.readLine());
		while (true) {
			answer = 0;
			size = 0;
			for (int i=0; i<R; i++) {
				String str = br.readLine();
				for (int j=0; j<C; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'o') {
						map[i][j] = (char)(size+48);
						list[size++] = new Pin(i, j);
					}
				}
			}
			
			DFS(0);
			sb.append(size-answer).append(" ").append(answer).append("\n");
			if (--test == 0) break; 
			br.readLine();
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int depth) {
		if (answer < depth) {
			answer = depth;
		}
		for (int i=0; i<size; i++) {
			if (check[i]) continue;
			
			Pin p = list[i];
			int x = p.x, y = p.y;
			
			int nx, ny;
			for (int d=0; d<4; d++) {
				nx = p.x + movex[d];
				ny = p.y + movey[d];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				
				if (map[nx][ny] != '.' && map[nx][ny] != '#') {
					int nnx = nx + movex[d];
					int nny = ny + movey[d];
					
					if (nnx < 0 || nnx >= R || nny < 0 || nny >= C) continue;
					
					if (map[nnx][nny] == '.') {
						char c = map[x][y];
						char nc = map[nx][ny];
						
						map[nnx][nny] = c;
						map[x][y] = '.';
						p.x = nnx;
						p.y = nny;
						check[map[nx][ny]-48] = true;
						map[nx][ny] = '.';
						
						DFS(depth+1);
						
						map[x][y] = c;
						map[nnx][nny] = '.';
						p.x = x;
						p.y = y;
						map[nx][ny] = nc;
						check[map[nx][ny]-48] = false;
					}
				}
			}
		}
	}
}
