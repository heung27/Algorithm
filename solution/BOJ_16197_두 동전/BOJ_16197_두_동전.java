import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16197_두_동전 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Coin {
		int x1, y1;
		int x2, y2;
		
		public Coin() {}
		
		public Coin(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static boolean[][][][] check;
	static char[][] map;
	static Coin coin;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		check = new boolean[R][C][R][C];
		map = new char[R][C];
		coin = new Coin();
		
		boolean t = false;
		
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'o') {
					if (!t) {
						coin.x1 = i;
						coin.y1 = j;
						t = true;
					}
					else {
						coin.x2 = i;
						coin.y2 = j;
					}
				}
			}
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<Coin> queue = new LinkedList<>();
		queue.offer(coin);
		check[coin.x1][coin.y1][coin.x2][coin.y2] = true;
		
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (++cnt > 10) return -1;
			
			while (size-- > 0) {
				Coin coin = queue.poll();
				
				for (int d=0; d<4; d++) {
					int nx1 = coin.x1 + movex[d];
					int ny1 = coin.y1 + movey[d];
					
					int nx2 = coin.x2 + movex[d];
					int ny2 = coin.y2 + movey[d];
					
					boolean require1 = nx1 < 0 || nx1 >= R || ny1 < 0 || ny1 >= C;
					boolean require2 = nx2 < 0 || nx2 >= R || ny2 < 0 || ny2 >= C;
					
					if (require1 && require2) continue;
					else if (require1 || require2) return cnt;
					
					if (map[nx1][ny1] == '#') {
						nx1 = coin.x1;
						ny1 = coin.y1;
					}
					
					if (map[nx2][ny2] == '#') {
						nx2 = coin.x2;
						ny2 = coin.y2;
					}
					
					if (nx1 == nx2 && ny1 == ny2) continue;
					
					if (!check[nx1][ny1][nx2][ny2]) {
						queue.offer(new Coin(nx1, ny1, nx2, ny2));
						check[nx1][ny1][nx2][ny2] = true;
					}
				}
			}
		}
		return -1;
	}
}
