import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열_돌리기4 {
	static int[][] list;
	static boolean[] check;
	static int[] numbers;
	static int[] moveX = {1, 0, -1, 0};
	static int[] moveY = {0, 1, 0, -1};
	static int[][] map;
	static int[][] temp;
	static int N, M, K;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		list = new int[K][3];
		temp = new int[N][M];
		map = new int[N][M];
		check = new boolean[K];
		numbers = new int[K];
		answer = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		
		int x, y, s;
		for (int i=0; i<K; i++) {
			str = br.readLine().split(" ");
			list[i][0] = Integer.parseInt(str[0])-1;
			list[i][1] = Integer.parseInt(str[1])-1;
			list[i][2] = Integer.parseInt(str[2]);
		}
		
		sol(0);
		
		System.out.println(answer);
	}
	
	static void rotate(int x, int y, int size) {
		int temp = map[x][y];
		int a = x, b = y;
		int dir = 0;
		int cnt = 0;
		while (true) {
			if (cnt == size-1) {
				dir = (dir + 1) % 4;
				cnt = 0;
			}
			int nextX = a + moveX[dir];
			int nextY = b + moveY[dir];
			if (nextX == x && nextY == y) break;
			map[a][b] = map[nextX][nextY];
			a = nextX;
			b = nextY;
			cnt++;
		}
		map[a][b] = temp;
	}
	
	static void sol(int cnt) {
		if (cnt == K) {
			init();
			int x, y, s;
			for (int i=0; i<K; i++) {
				x = list[numbers[i]][0];
				y = list[numbers[i]][1];
				s = list[numbers[i]][2];
				
				int size = s * 2 + 1;
				for (int k=0; k<s; k++) {
					rotate(x-s+k, y-s+k, size);
					size -= 2;
				}
			}
			answer = Math.min(answer, sum());
			return;
		}
		for (int i=0; i<K; i++) {
			if (check[i]) continue;
			numbers[cnt] = i;
			check[i] = true;
			sol(cnt+1);
			check[i] = false;
		}
	}
	
	static int sum() {
		int min = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			int sum = 0;
			for (int j=0; j<M; j++) {
				sum += map[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
	
	static void init() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}

