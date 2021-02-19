import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2667_단지번호붙이기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static ArrayList<Integer> answer = new ArrayList<>();
	static int[][] map;
	static boolean[][] check;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!check[i][j] && map[i][j] == 1) {
					BFS(i,j);
				}
			}
		}
		
		Collections.sort(answer);
		int size = answer.size();
		sb.append(size).append("\n");
		for (int i=0; i<size; i++) {
			sb.append(answer.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		check[x][y] = true;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			cnt++;
			
			for (int i=0; i<4; i++) {
				int nx = pos[0] + movex[i];
				int ny = pos[1] + movey[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if (!check[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new int[] {nx,ny});
					check[nx][ny] = true;
				}
			}
		}
		answer.add(cnt);
	}
}
