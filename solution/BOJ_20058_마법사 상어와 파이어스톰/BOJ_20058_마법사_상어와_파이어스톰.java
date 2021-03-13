import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_20058_마법사_상어와_파이어스톰 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] movex = {1, 0, -1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][] map;
	static boolean[][] check;
	static int N, Q, size;
	static int answer, max;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		Q = Integer.parseInt(str[1]);
		
		size = (int)Math.pow(2, N);
		map = new int[size][size];
		check = new boolean[size][size];
		
		for (int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while (Q-- > 0) {
			int L = Integer.parseInt(st.nextToken());
			divide(0, 0, N-L, size);
			ice();
		}
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (!check[i][j] && map[i][j] != 0) BFS(i, j);
			}
		}
		
		System.out.println(answer);
		System.out.println(max);
	}
	
	static void divide(int x, int y, int k, int len) {
		if (k == 0) {
			rotate(x, y, len);
			return;
		}
		len = len/2;
		divide(x, y, k-1, len);
		divide(x, y+len, k-1, len);
		divide(x+len, y, k-1, len);
		divide(x+len, y+len, k-1, len);
	}
	
	static void rotate(int x, int y, int len) {
			int[][] temp = new int[len][len];
			for (int i=x; i<x+len; i++) {
				for (int j=y; j<y+len; j++) {
					temp[j-y][x+len-1-i] = map[i][j];
				}
			}
			
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					map[i+x][j+y] = temp[i][j];
				}
			}
	}
	
	static void ice() {
		Stack<int[]> stack = new Stack<>();
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (map[i][j] == 0) continue;
				
				int cnt = 0;
				for (int d=0; d<4; d++) {
					int nx = i + movex[d];
					int ny = j + movey[d];
					
					if (nx < 0 || nx >= size || ny < 0 || ny >= size || map[nx][ny] == 0) cnt++;
					
				}
				if (cnt >= 2) stack.add(new int[] {i, j});
			}
		}
		
		while (!stack.isEmpty()) {
			int[] pos = stack.pop();
			map[pos[0]][pos[1]]--;
		}
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		check[x][y] = true;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			answer += map[pos[0]][pos[1]];
			cnt++;
			
			for (int i=0; i<4; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
				
				if (!check[nx][ny] && map[nx][ny] != 0) {
					queue.offer(new int[] {nx, ny});
					check[nx][ny] = true;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
