import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15684_사다리_조작 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<int[]> list = new ArrayList<>();
	static int[][] map;
	static int N, M, H;
	static int answer, size;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);
		map = new int[H+1][N+1];
		
		while (M-- > 0) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			map[a][b] = 1;
			map[a][b+1] = -1;
		}
		
		for (int i=1; i<=H; i++) {
			for (int j=1; j<N; j++) {
				if (map[i][j] == 0 && map[i][j+1] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}
		size = list.size();
		
		for ( ; answer<4; answer++) {
			Combination(0, 0);
			if (check) break;
		}
		
		if (check) System.out.println(answer);
		else System.out.println(-1);
	}
	
	static boolean down(int y) {
		int start = y;
		for (int i=1; i<=H; i++) { 
			if (map[i][start] == -1) { // Left
				start--;
			}
			else if (map[i][start] == 1) { // Right
				start++;
			}
		}
		if (y == start) return true;
		else return false;
	}
	
	static void Combination(int cnt, int start) {
		if (check) return;
		
		if (cnt == answer) {
			int j = 1;
			for ( ; j<=N; j++) {
				if (!down(j)) break;
			}
			if (j == N+1) check = true;
			return;
		}
		
		for (int i=start; i<size; i++) {
			int[] pos = list.get(i);
			int x = pos[0], y = pos[1];
			if (map[x][y] == 0) {
				map[x][y] = 1;
				map[x][y+1] = -1;
				Combination(cnt+1, i+1);
				map[x][y] = 0;
				map[x][y+1] = 0;
			}
		}
	}
}
