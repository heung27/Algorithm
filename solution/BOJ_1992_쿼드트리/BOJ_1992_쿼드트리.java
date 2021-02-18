import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		sol(0, 0, N);
		System.out.println(sb);
	}
	
	static void sol(int x, int y, int n) {
		if (!check(x,y,n)) {
			sb.append("(");
			n >>= 1;
			for (int i=0; i<2; i++) {
				for (int j=0; j<2; j++) {
					sol(x+i*n, y+j*n, n);
				}
			}
			sb.append(")");
		}
	}
	
	static boolean check(int x, int y, int n) {
		int temp = map[x][y];
		for (int i=x; i<x+n; i++) {
			for (int j=y; j<y+n; j++) {
				if (temp != map[i][j]) {
					return false;
				}
			}
		}
		sb.append(temp);
		return true;
	}
}
