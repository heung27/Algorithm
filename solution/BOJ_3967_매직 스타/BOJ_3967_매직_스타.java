import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3967_매직_스타 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<int[]> list = new ArrayList<>();
	static int[][][] check = new int[5][9][2];
	static int[][] map = new int[5][9];
	static int[] sum = new int[7];
	static boolean[] numbers = new boolean[13];
	static int cnt = 1, size;
	static boolean t;
	
	public static void main(String[] args) throws IOException {
		for (int i=0; i<5; i++) {
			String str = br.readLine();
			for (int j=0; j<9; j++) {
				char c = str.charAt(j);
				if (c == '.') continue;
				else if (c == 'x') {
					map[i][j] = -1;
					list.add(new int[] {i, j});
				}
				else {
					map[i][j] = c-64;
					numbers[map[i][j]] = true;
				}
			}
		}
		
		int add1 = 0, add2 = 0;
		int x = 0, y = 4;
		for (int i=0; i<4; i++) {
			add1 += func(x+i, y-i, 1);
			add2 += func(x+i, y+i, 2);
		}
		sum[cnt++] = add1;
		sum[cnt++] = add2;
		
		add1 = 0; add2 = 0;
		x = 4; y = 4;
		for (int i=0; i<4; i++) {
			add1 += func(x-i, y-i, 3);
			add2 += func(x-i, y+i, 4);
		}
		sum[cnt++] = add1;
		sum[cnt++] = add2;
		
		add1 = 0; add2 = 0;
		x = 1; y = 1;
		for (int i=0; i<8; i+=2) {
			add1 += func(x, y+i, 5);
		}
		sum[cnt++] = add1;
		x = 3; y = 1;
		for (int i=0; i<8; i+=2) {
			add2 += func(x, y+i, 6);
		}
		sum[cnt++] = add2;
		
		size = list.size();
		
		DFS(0);
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				if (map[i][j] == 0) sb.append(".");
				else sb.append((char)(map[i][j]+64));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int func(int nx, int ny, int num) {
		if (map[nx][ny] < 0) {
			if (check[nx][ny][0] == 0) check[nx][ny][0] = num;
			else {
				check[nx][ny][1] = num;
			}
			return 0;
		}
		else return map[nx][ny];
	}
	
	static boolean DFS(int cnt) {
		if (cnt == size) {
			int i = 1;
			for ( ; i<=6; i++) {
				if (sum[i] != 26) break;
			}
			if (i == 7) return true;
			return false;
		}
		int[] pos = list.get(cnt);
		int index1 = check[pos[0]][pos[1]][0];
		int index2 = check[pos[0]][pos[1]][1];
		
		for (int j=1; j<=12; j++) {
			if (!numbers[j]) {
				sum[index1] += j;
				sum[index2] += j;
				map[pos[0]][pos[1]] = j;
				numbers[j] = true;
				if (sum[index1] <= 26 && sum[index2] <= 26) if (DFS(cnt+1)) return true;
				sum[index1] -= j;
				sum[index2] -= j;
				numbers[j] = false;
			}
		}
		return false;
	}
}

