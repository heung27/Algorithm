import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_2665_미로만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean[][] visit;
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			String temp = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		int answer = 0;
		int[] movex = {-1, 0, 1, 0};
		int[] movey = {0, 1, 0, -1};
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		queue.offer(new int[] {0, 0, 0});
		visit[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			if (pos[0] == N-1 && pos[1] == N-1) {
				answer = pos[2];
				break;
			}
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;
				
				visit[nx][ny] = true;
				if (map[nx][ny] == 0) {
					queue.offer(new int[] {nx, ny, pos[2]+1});
				} else {
					queue.offer(new int[] {nx, ny, pos[2]});
				}
			}
		}
		
		System.out.println(answer);
	}
}
