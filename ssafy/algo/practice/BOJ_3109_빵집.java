import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1};
	static char[][] map;
	static int R, C;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new char[R][C];
		
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for (int i=0; i<R; i++) {
			if (DFS(i,0)) cnt++;
		}
		System.out.println(cnt);
	}
	
	static boolean DFS(int x, int y) {
		if (y == C-1) {
			return true;
		}
		for (int i=0; i<3; i++) {
			int nx = x+movex[i];
			int ny = y+1;
			
			if (nx < 0 || nx >= R || ny >= C) continue;
			
			if (map[nx][ny] == '.') {
				map[nx][ny] = 'x';
				if (DFS(nx, ny)) return true;
			}
		}
		return false;
	}
}
