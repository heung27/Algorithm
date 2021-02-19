import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static char[][] map;
	static boolean[] visit;
	static int R, C;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		map = new char[R][C];
		visit = new boolean[26];
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		DFS(0, 0, 1);
		System.out.println(answer);
	}
	
	static void DFS(int x, int y, int cnt) {
		visit[map[x][y]-'A'] = true;
		for (int i=0; i<4; i++) {
			int nx = x + movex[i];
			int ny = y + movey[i];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			
			if (!visit[map[nx][ny]-'A']) {
				DFS(nx, ny, cnt+1);
			}
		}
		visit[map[x][y]-'A'] = false;
		if (answer < cnt) answer = cnt;
	}
}
