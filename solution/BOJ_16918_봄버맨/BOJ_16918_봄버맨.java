import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_16918_봄버맨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static boolean[][] map1, map2;
	static int R, C, N;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		N = Integer.parseInt(str[2]);
		
		map1 = new boolean[R][C];
		map2 = new boolean[R][C];
		
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				if (s.charAt(j) == 'O') map1[i][j] = true;
				else map2[i][j] = true;
			}
		}
		
		if (N % 2 == 0) {
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
		}
		else {
			int temp = N = N/2;
			while (true) {
				if (--temp < 0) break;
				boom(map1, map2);
				if (--temp < 0) break;
				boom(map2, map1);
			}
			if (N % 2 == 0) printMap(map1);
			else printMap(map2);
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void boom(boolean[][] temp1, boolean[][] temp2) {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (temp1[i][j]) {
					temp2[i][j] = false;
					for (int d=0; d<4; d++) {
						int nx = i + movex[d];
						int ny = j + movey[d];
						
						if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
						
						temp2[nx][ny] = false;
					}
				}
				else temp1[i][j] = true;
			}
		}
	}
	
	static void printMap(boolean[][] temp) {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (temp[i][j]) sb.append('O');
				else sb.append('.');
			}
			sb.append("\n");
		}
	}
}
