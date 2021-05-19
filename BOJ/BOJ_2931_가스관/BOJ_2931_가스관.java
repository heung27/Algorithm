import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2931_가스관 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static char[] put = {'|', '-', '+', '1', '2', '3', '4'};
	
	static int[] movex = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] movey = {0, 1, 0, -1};
	
	static int[] start = new int[2];
	
	static char[][] map;
	static int R, C;
	static boolean check;
	
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		map = new char[R][C];
		
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'M') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		for (int d=0; d<4; d++) {
			int nx = start[0]+movex[d];
			int ny = start[1]+movey[d];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			
			if (map[nx][ny] != '.' && map[nx][ny] != 'Z') {
				move(nx, ny, d);
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean move(int x, int y, int d) {
		int nd, nx, ny;
		while (map[x][y] != '.') {
			nd = block(map[x][y], d);
			if (nd == -1) return false;
			
			x += movex[nd];
			y += movey[nd];
			
			if (x < 0 || x >= R || y < 0 || y >= C) return false;
			
			if (map[x][y] == 'Z') return true;
			d = nd;
		}
		
		if (check) return false;
		check = true;
		sb.append(x+1).append(" ").append(y+1).append(" ");
		
		for (int i=0; i<7; i++) {
			map[x][y] = put[i];
			nd = block(map[x][y], d);
			if (nd == -1) continue;
			
			nx = x + movex[nd];
			ny = y + movey[nd];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'Z' || map[nx][ny] == 'M') continue;
			
			if (move(nx, ny, nd)) {
				sb.append(map[x][y]);
				return true;
			}
		}
		return false;
	}
	
	 // 상 우 하 좌
	static int block(int c, int d) {
		switch (c) {
		case '|': 
			if (d % 2 == 1) d = -1;
			break;
		case '-':
			if (d % 2 == 0) d = -1;
			break;
		case '1':
			if (d == 3) d = 2;
			else if (d == 0) d = 1;
			else d = -1;
			break;
		case '2':
			if (d == 3) d = 0;
			else if (d == 2) d = 1;
			else d = -1;
			break;
		case '3':
			if (d == 1) d = 0;
			else if (d == 2) d = 3;
			else d = -1;
			break;
		case '4':
			if (d == 1) d = 2;
			else if (d == 0) d = 3;
			else d = -1;
			break;
		}
		return d;
	}
}
