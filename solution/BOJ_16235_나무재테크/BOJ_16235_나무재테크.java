import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static StringTokenizer st;
	
	static class Tree {
		int age;

		public Tree(int age) {
			super();
			this.age = age;
		}
	}
	
	static int[] movex = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] movey = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static Queue<int[]> breed = new LinkedList<>();
	static Deque<Tree>[][] mat;
	static int[][] temp;
	static int[][] map;
	static int N, M, K;
	static int answer;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		temp = new int[N+1][N+1];
		map = new int[N+1][N+1];
		mat = new Deque[N+1][N+1];
		answer = M;
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				temp[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int z = Integer.parseInt(str[2]);
			
			mat[x][y] = new ArrayDeque<>();
			mat[x][y].offer(new Tree(z));
		}
		
		while (K-- > 0) {
			spring_summer();
			fall();
			winter();
		}
		
		System.out.println(answer);
	}
	
	static void spring_summer() {
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (mat[i][j] != null) {
					Iterator<Tree> iter = mat[i][j].iterator();
					while (iter.hasNext()) {
						Tree t = iter.next();
						if (map[i][j] >= t.age) {
							map[i][j] -= t.age;
							
							if (++(t.age) % 5 == 0) breed.offer(new int[] {i, j}); 
						}
						else {
							map[i][j] += t.age / 2;
							summer(iter, i, j);
							break;
						}
					}
				}
			}
		}
	}
	
	static void summer(Iterator<Tree> iter, int i, int j) {
		int death_cnt = 1;
		while (iter.hasNext()) {
			Tree t = iter.next();
			map[i][j] += t.age / 2;
			death_cnt++;
		}
		answer -= death_cnt;
		while (death_cnt-- > 0) mat[i][j].pollLast();
	}

	static void fall() {
		while (!breed.isEmpty()) {
			int[] pos = breed.poll();
			for (int j=0; j<8; j++) {
				int nx = pos[0] + movex[j];
				int ny = pos[1] + movey[j];
				
				if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
				
				if (mat[nx][ny] == null) mat[nx][ny] = new ArrayDeque<>();
				mat[nx][ny].offerFirst(new Tree(1));
				answer++;
			}
		}
	}
	
	static void winter() {
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}
}
