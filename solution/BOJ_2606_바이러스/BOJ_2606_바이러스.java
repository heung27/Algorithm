import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[][] map;
	static boolean[] check;
	static int N, M, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		check = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map[x][y] = true;
			map[y][x] = true;
		}
		DFS(1);
		System.out.println(cnt);
	}
	
	static void DFS(int x) {
		check[x] = true;
		for (int i=1; i<N+1; i++) {
			if (map[x][i] && !check[i]) {
				cnt++;
				DFS(i);
			}
		}
	}
}
