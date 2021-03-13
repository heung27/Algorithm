import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13460_구슬_탈출_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static char[][] map;
	static int R, C, answer;
	
	static Point red, blue, end;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		map = new char[R][C];
		
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				
				switch(map[i][j]) {
				case 'R': red = new Point(i, j); break;
				case 'B': blue = new Point(i, j); break;
				case 'O': end = new Point(i, j);
				}
			}
		}
		
		if (rotate()) System.out.println(answer);
		else System.out.println(-1);
	}
	
	static boolean rotate() {
		Queue<Point[]> queue = new LinkedList<>();
		queue.offer(new Point[] {red, blue});
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (++answer > 10) return false;
			
			while (size-- > 0) {
				Point[] color = queue.poll();
				
				for (int i=0; i<4; i++) {
					Point red = new Point(color[0].x, color[0].y);
					Point blue = new Point(color[1].x, color[1].y);
					
					int cnt1 = move(red, i);
					int cnt2 = move(blue, i);
					
					if (red.x == blue.x && red.y == blue.y) {
						if (red.x == end.x && red.y == end.y) continue;
							
						if (cnt1 < cnt2) {
							blue.x -= movex[i];
							blue.y -= movey[i];
						}
						else {
							red.x -= movex[i];
							red.y -= movey[i];
						}
					}
					else if (red.x == end.x && red.y == end.y) return true;
					else if (blue.x == end.x && blue.y == end.y) continue; 
					
					if (red.x != color[0].x || red.y != color[0].y || blue.x != color[1].x || blue.y != color[1].y)
						queue.offer(new Point[] {red, blue});
				}
			}
		}
		return false;
	}
	
	static int move(Point color, int d) {
		int nx = color.x, ny = color.y;
		int cnt = 0;
		
		while (true) {
			nx = color.x + movex[d];
			ny = color.y + movey[d];
			
			if (map[nx][ny] == '#') break;
			
			color.x = nx;
			color.y = ny;
			cnt++;
			
			if (map[nx][ny] == 'O') break;
		}
		
		return cnt;
	}
}
