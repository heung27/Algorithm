import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열_돌리기3 {
	static int[][] map;
	static int N, M, R;
	static int X, Y, size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		size = Math.max(N, M);
		map = new int[size][size];

		X = (size-N)/2;
		Y = (size-M)/2;
		
		for (int i=X; i<X+N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=Y; j<Y+M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while (R-- > 0) {
			int x = Integer.parseInt(st.nextToken());
			switch (x) {
			case 1:
				UpDown();
				break;
			case 2:
				LeftRight();
				break;
			case 3:
				Right90();
				break;
			case 4: 
				Left90();
				break;
			case 5:
				rotateR();
				break;
			case 6:
				rotateL();
			}
		}
		
		for (int i=X; i<X+N; i++) {
			for (int j=Y; j<Y+M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void UpDown() { // 1번
		int temp;
		for (int j=Y; j<Y+M; j++) {
			for (int i=X; i<X+N/2; i++) {
				temp = map[i][j];
				map[i][j] = map[size-i-1][j];
				map[size-i-1][j] = temp;
			}
		}
	}
	
	static void LeftRight() { // 2번
		int temp;
		for (int i=X; i<X+N; i++) {
			for (int j=Y; j<Y+M/2; j++) {
				temp = map[i][j];
				map[i][j] = map[i][size-j-1];
				map[i][size-j-1] = temp;
			}
		}
	}
	
	static void Right90() { // 3번
		int[][] temp = new int[size][size];

		for (int j=Y; j<Y+M; j++) {
			for (int i=X; i<X+N; i++) {
				temp[j][i] = map[size-i-1][j];
			}
		}
		NMXY();
		copyMap(temp);
	}
	
	static void Left90() { // 4번
		int[][] temp = new int[size][size];

		for (int j=Y; j<Y+M; j++) {
			for (int i=X; i<X+N; i++) {
				temp[j][i] = map[i][size-j-1];
			}
		}
		NMXY();
		copyMap(temp);
	}
	
	static void NMXY() { // 3번 or 4번 회전 했을 때 row, col 스왑
		int temp = N;
		N = M;
		M = temp;
		
		temp = X;
		X = Y;
		Y = temp;
	}
	
	static void copyMap(int[][] temp) { // 3번, 4번  map <- temp
		for (int i=X; i<X+N; i++) {
			for (int j=Y; j<Y+M; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	static void rotateR() { // 5번 
		int[] moveX = {N/2, 0, -N/2, 0}; // 반시계 방향
		int[] moveY = {0, M/2, 0, -M/2};
		rotate(moveX, moveY);
	}
	
	static void rotateL() { // 6번
		int[] moveX = {0, N/2, 0, -N/2}; // 시계 방향
		int[] moveY = {M/2, 0, -M/2, 0};
		rotate(moveX, moveY);
	}
	
	static void rotate(int[] moveX, int[] moveY) { // 5번, 6번 동작
		int temp;
		for (int i=X; i<X+N/2; i++) {
			for (int j=Y; j<Y+M/2; j++) {
				temp = map[i][j];
				int a = i, b = j, x, y;
				for (int k=0; k<3; k++) {
					x = a + moveX[k];
					y = b + moveY[k];
					map[a][b] = map[x][y];
					a = x;
					b = y;
				}
				map[a][b] = temp;
			}
		}
	}
}
