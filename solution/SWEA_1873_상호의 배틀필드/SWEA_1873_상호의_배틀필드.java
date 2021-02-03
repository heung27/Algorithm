import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1873_상호의_배틀필드 {
	public static int[] moveX = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
	public static int[] moveY = {1, 0, -1, 0};
	public static char[][] map;
	public static int X, Y;
	public static int H, W;
	public static int act;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			H = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			map = new char[H][W];
			for (int i=0; i<H; i++) {
				String[] s = br.readLine().split("");
				for (int j=0; j<W; j++) {
					map[i][j] = s[j].charAt(0);
					if (map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						X = i;
						Y = j;
					}
				}
			}
			bw.write("#"+t+" ");
			act = Integer.parseInt(br.readLine());
			String[] m = br.readLine().split("");
			for (int i=0; i<act; i++) {
				char c = m[i].charAt(0);
				switch (c) {
				case 'U': case 'D': case 'L': case 'R': move(c); break;
				case 'S': shoot();
				}
			}
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					bw.write(map[i][j]);
				}
				bw.write("\n");
			}
		}
		bw.flush();
	}
	
	public static void move(char c) {
		int xx = 0, yy = 0;
		switch (c) {
		case 'R' :
			map[X][Y] = '>';
			xx = X + moveX[0];
			yy = Y + moveY[0];
			if (yy < W && map[xx][yy] == '.') {
				map[X][Y] = '.';
				X = xx;
				Y = yy;
				map[X][Y] = '>';
			}
			break;
		case 'D' :
			map[X][Y] = 'v';
			xx = X + moveX[1];
			yy = Y + moveY[1];
			if (xx < H && map[xx][yy] == '.') {
				map[X][Y] = '.';
				X = xx;
				Y = yy;
				map[X][Y] = 'v';
			}
			break;
		case 'L' :
			map[X][Y] = '<';
			xx = X + moveX[2];
			yy = Y + moveY[2];
			if (yy >= 0 && map[xx][yy] == '.') {
				map[X][Y] = '.';
				X = xx;
				Y = yy;
				map[X][Y] = '<';
			}
			break;
		case 'U' :
			map[X][Y] = '^';
			xx = X + moveX[3];
			yy = Y + moveY[3];
			if (xx >= 0 && map[xx][yy] == '.') {
				map[X][Y] = '.';
				X = xx;
				Y = yy;
				map[X][Y] = '^';
			}
			break;
		}
	}

	public static void shoot() {
		char c = map[X][Y];
		int dir = -1;
		switch (c) {
		case '>' :
			dir = 0;
			break;
		case 'v' :
			dir = 1;
			break;
		case '<' :
			dir = 2;
			break;
		case '^' :
			dir = 3;
			break;
		}
		int x = X + moveX[dir], y = Y + moveY[dir];
		while (x >= 0 && x < H && y >= 0 && y < W) {
			if (map[x][y] == '*') {
				map[x][y] = '.';
				break;
			}
			else if (map[x][y] == '#') break;
			x += moveX[dir];
			y += moveY[dir];
		}
	}
}
