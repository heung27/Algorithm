import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_18428_감시_피하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static Point[] students = new Point[30];
	static Point[] emptys = new Point[36];
	
	static char[][] map;
	static int N, sLen, eLen;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				
				if (map[i][j] == 'X') {
					emptys[eLen++] = new Point(i, j);
				}
				else if (map[i][j] == 'S'){
					students[sLen++] = new Point(i, j);
				}
			}
		}
		
		if (combination(0, 0)) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static boolean combination(int cnt, int start) {
		if (cnt == 3) {
			for (int i=0; i<sLen; i++) {
				for (int d=0; d<4; d++) {
					int x = students[i].x;
					int y = students[i].y;
				
					while (true) {
						x += movex[d];
						y += movey[d];
						
						if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] == 'O') break;
						
						if (map[x][y] == 'T') return false;
					}
				}
			}
			return true;
		}
		
		for (int i=start; i<eLen; i++) {
			map[emptys[i].x][emptys[i].y] = 'O';
			if (combination(cnt+1, i+1)) return true;
			map[emptys[i].x][emptys[i].y] = 'X';
		}
		
		return false;
	}
}
