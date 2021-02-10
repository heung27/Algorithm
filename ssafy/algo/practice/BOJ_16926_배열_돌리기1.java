import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열_돌리기1 {
	static int[] moveX = {0, 1, 0, -1};
	static int[] moveY = {1, 0, -1, 0};
	static int[][] map;
	static int N, M, R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (R-- > 0) {
			int range = N < M ? N/2 : M/2; 
			int n = N, m = M;
			for (int k=0; k<range; k++) {
				rotate(k, k, m, n);
				n -= 2;
				m -= 2;
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void rotate(int x, int y, int n, int m) {
		int temp = map[x][y];
		int a = x, b = y;
		int dir = 0;
		int cnt = 0;
		while (true) {
			if (cnt == n-1 && dir % 2 == 0) {
				dir = (dir + 1) % 4;
				cnt = 0;
			}
			else if (cnt == m-1 && dir % 2 == 1) {
				dir = (dir + 1) % 4;
				cnt = 0;
			}
			int nextX = a + moveX[dir];
			int nextY = b + moveY[dir];
			if (nextX == x && nextY == y) break;
			map[a][b] = map[nextX][nextY];
			a = nextX;
			b = nextY;
			cnt++;
		}
		map[a][b] = temp;
	}
	
//	static void rotate(int x, int y, int n, int m) { 규칙 찾아서 계산... fail..
//		if (n == 1 || m == 1) return;
//		for (int j=y; j<y+m-1; j++) {
//			map[x][j] += 1;
//		}
//		for (int i=x; i<x+n-1; i++) {
//			map[i][y+m-1] += 4;
//		}
//		for (int j=y+m-1; j>y; j--) {
//			map[x+n-1][j] -= 1;
//		}
//		for (int i=x+n-1; i>x; i--) {
//			map[i][y] -= 4;
//		}
//		rotate(x+1, y+1, n/2, m/2);
//	}
}