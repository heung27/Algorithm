import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map = new int[9][9];
	static int[][] zero = new int[81][2];
	
	static boolean[][] row = new boolean[9][10];
	static boolean[][] col = new boolean[9][10];
	static boolean[][] box = new boolean[9][10];
	
	static int size;
	
	public static void main(String[] args) throws IOException {
		for (int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zero[size][0] = i;
					zero[size++][1] = j;
				}
				else {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					box[(i/3)*3 + j/3][map[i][j]] = true;
				}
			}
		}
		
		DFS(0);
		
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean DFS(int cnt) {
		if (cnt == size) {
			return true;
		}
		
		for (int i=1; i<10; i++) {
			int x = zero[cnt][0], y = zero[cnt][1];
			if (!check(x, y, i)) continue;
			
			map[x][y] = i;
			
			row[x][i] = true;
			col[y][i] = true;
			box[(x/3)*3 + y/3][i] = true;
			
			if (DFS(cnt+1)) return true;
			
			row[x][i] = false;
			col[y][i] = false;
			box[(x/3)*3 + y/3][i] = false;
		}
		return false;
	}
	
	static boolean check(int x, int y, int i) {
		if (row[x][i]) return false;
		
		if (col[y][i]) return false;
		
		if (box[(x/3)*3 + y/3][i]) return false;
		
		return true;
	}
}
