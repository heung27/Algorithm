import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map;
	static int N, cnt;
	static int white, blue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0, 0, N);
		
		sb.append(white).append("\n").append(blue);
		System.out.println(sb);
	}
	
	static void solution(int x, int y, int n) {
		if (!check(x, y, n)) {
			int k = n/2;
			for (int i=0; i<2; i++) {
				for (int j=0; j<2; j++) {
					solution(x+(i*k), y+(j*k), k);
				}
			}
		}
	}
	
	static boolean check(int x, int y, int n) {
		int first = map[x][y];
		for (int i=x; i<x+n; i++) {
			for (int j=y; j<y+n; j++) {
				if (first != map[i][j]) {
					return false;
				}
			}
		}
		if (first == 0) white++;
		else blue++;
		
		return true;
	}
}
