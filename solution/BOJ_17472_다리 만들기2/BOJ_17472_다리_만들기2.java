import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17472_다리_만들기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Ladder {
		int x, y;
		int d;
		int num;
		
		public Ladder(int x, int y, int d, int num) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.num = num;
		}
	}
	
	static Queue<Ladder> queue_ladder = new LinkedList<>();
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int INF = Integer.MAX_VALUE >> 1;
	static int num = 2; // 섬의 개수
	
	static int[][] map, dist;
	
	static int N, M;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 1) {
					BFS(i, j);
					num++;
				}
			}
		}
		
		move(); // 다리 놓기
		Prim(); // 최소 거리 구하기
		
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	static void BFS(int x, int y) { 
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		map[x][y] = num;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int d=0; d<4; d++) {
				int nx = pos[0] + movex[d];
				int ny = pos[1] + movey[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if (map[nx][ny] == 0) { // 다리의 시작 공간 저장
					queue_ladder.offer(new Ladder(nx, ny, d, num));
				}
				else if (map[nx][ny] == 1){ // 섬의 개수 카운트
					queue.offer(new int[] {nx, ny}); 
					map[nx][ny] = num;
				}
			
			}
		}
	}
	
	static void move() {
		dist = new int[num][num]; // 각 섬들 사이의 거리 저장
		
		for (int i=2; i<num; i++) {
			for (int j=2; j<num; j++) {
				dist[i][j] = INF;
			}
		}
		for (int i=2; i<num; i++) {
			dist[i][i] = 0;
		}

		while (!queue_ladder.isEmpty()) { // 모든 다리의 시작 공간을 검사
			Ladder temp = queue_ladder.poll();
			
			int cnt = 0; // 다리 길이
			
			int nx = temp.x, ny = temp.y;
			while (map[nx][ny] == 0) {
				nx += movex[temp.d];
				ny += movey[temp.d];
				cnt++;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					cnt = -1;
					break;
				}
			}
			
			if (cnt >= 2 && dist[temp.num][map[nx][ny]] > cnt) dist[temp.num][map[nx][ny]] = cnt;
		}
	}
	
	static void Prim() {
		int[] minEdge = new int[num];
		boolean[] visit = new boolean[num];
		
		Arrays.fill(minEdge, INF);
		minEdge[2] = 0;
		
		for (int c=2; c<num; c++) {
			int min = INF;
			int Vertex = 0;
			
			for (int i=2; i<num; i++) {
				if (!visit[i] && min > minEdge[i]) {
					min = minEdge[i];
					Vertex = i;
				}
			}
			
			if (Vertex == 0) {
				answer = -1;
				return;
			}
			answer += min;
			visit[Vertex] = true;
			
			for (int i=2; i<num; i++) {
				if(!visit[i] && dist[Vertex][i] != 0 && minEdge[i] > dist[Vertex][i]) {
					minEdge[i] = dist[Vertex][i];
				}
			}
		}
	}
}
