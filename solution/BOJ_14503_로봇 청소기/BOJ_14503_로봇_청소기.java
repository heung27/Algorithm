import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14503_로봇_청소기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static boolean[][] check;
	static int[][] map;
	static int N, M;
	static int x, y, d; // d: 북, 동, 남, 서
	static int answer = 1;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		check = new boolean[N][M];
		
		str = br.readLine().split(" ");
		x = Integer.parseInt(str[0]);
		y = Integer.parseInt(str[1]);
		d = Integer.parseInt(str[2]);
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[x][y] = -1;
		
		int cnt = 0;
		while (true) {
			d = (d - 1 + 4) % 4;
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (map[nx][ny] == 0) {
				map[nx][ny] = -1;
				answer++;
				x = nx;
				y = ny;
				cnt = 0;
			}
			else {
				if (++cnt == 4) {
					int bx = x - movex[d];
					int by = y - movey[d];
					
					if (map[bx][by] == 1) break;
					
					x = bx;
					y = by;
					cnt = 0;
				}
			}
		}
		System.out.println(answer);
	}
}
