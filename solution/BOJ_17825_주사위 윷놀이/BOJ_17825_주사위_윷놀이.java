import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_17825_주사위_윷놀이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Point {
		int line, x;

		public Point(int line, int x, int pre) {
			this.line = line;
			this.x = x;
		}
	}
	
	static int[] zero = new int[21];
	static int[] first = {10, 13, 16, 19, 25, 30, 35, 40};
	static int[] second = {20, 22, 24, 25, 30, 35, 40};
	static int[] third = {30, 28, 27, 26, 25, 30, 35, 40};
	
	static int[] dice = new int[10];
	static Point[] point = new Point[4];
	static boolean[] check = new boolean[4]; // 도착 체크
	static boolean[] check0 = new boolean[41]; // 테두리 방문 체크
	static boolean[] check40 = new boolean[41]; // 가운데 방문 체크
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		for (int i=0; i<10; i++) {
			dice[i] = Integer.parseInt(str[i]);
		}
		
		zero[0] = 0;
		for (int j=1; j<=20; j++) {
			zero[j] = 2 * j;
		}
		
		for (int i=0; i<4; i++) {
			point[i] = new Point(0, 0, 0);
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}
	
	static void DFS(int depth, int sum) {
		if (depth == 10) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i=0; i<4; i++) { 
			if (check[i]) continue;

			int nx = point[i].x + dice[depth];
			
			if (point[i].line == 0) {
				if (nx >= zero.length) {
					int preX = point[i].x;
					if (zero[preX] == 40) check40[40] = false;
					check0[zero[preX]] = false;
					check[i] = true;
					
					DFS(depth+1, sum);
					
					check0[zero[preX]] = true;
					check[i] = false;
					if (zero[preX] == 40) check40[40] = true;
				}
				else if (!check0[zero[nx]] && (zero[nx] != 40 || !check40[40])) {
					int preX = point[i].x;
					
					check0[zero[preX]] = false;
					check0[zero[nx]] = true;
					point[i].x = nx;
					
					switch (nx) {
					case 5: point[i].line = 1; point[i].x = 0; break;
					case 10: point[i].line = 2; point[i].x = 0; break;
					case 15: point[i].line = 3; point[i].x = 0; break;
					}
					
					if (nx != 20) DFS(depth+1, sum+zero[nx]);
					else {
						check40[40] = true;
						DFS(depth+1, sum+zero[nx]);
						check40[40] = false;
					}
					
					point[i].line = 0;
					
					check0[zero[preX]] = true;
					check0[zero[nx]] = false;
					point[i].x = preX;
				}
			}
			else if (point[i].line == 1) {
				if (nx >= first.length) {
					func(depth, sum, i, point[i].x, first[point[i].x]);
				}
				else if (!check40[first[nx]] && (first[nx] != 40 || !check0[40])){
					int preX = point[i].x;
					func2(depth, sum, i, preX, nx, first[preX], first[nx]);
				}
			}
			else if (point[i].line == 2) {
				if (nx >= second.length) {
					func(depth, sum, i, point[i].x, second[point[i].x]);
				}
				else if (!check40[second[nx]] && (second[nx] != 40 || !check0[40])){
					int preX = point[i].x;
					func2(depth, sum, i, preX, nx, second[preX], second[nx]);
				}
			}
			else if (point[i].line == 3) {
				if (nx >= third.length) {
					func(depth, sum, i, point[i].x, third[point[i].x]);
				}
				else if (!check40[third[nx]] && (third[nx] != 40 || !check0[40])){
					int preX = point[i].x;
					func2(depth, sum, i, preX, nx, third[preX], third[nx]);
				}
			}
		}
	}
	
	static void func(int depth, int sum, int i, int preX, int preNum) {
		if (preNum == 40) check0[40] = false;
		check40[preNum] = false;
		check[i] = true;
		
		DFS(depth+1, sum);
		
		check40[preNum] = true;
		check[i] = false;
		if (preNum == 40) check0[40] = true;
	}
	
	static void func2(int depth, int sum, int i, int preX, int nx, int preNum, int nextNum) {
		if (preX == 0) check0[preNum] = false;
		else check40[preNum] = false;
		if (nextNum == 40) check0[40] = true;
		check40[nextNum] = true;
		point[i].x = nx;
		
		DFS(depth+1, sum+nextNum);
		
		point[i].x = preX;
		check40[nextNum] = false;
		if (nextNum == 40) check0[40] = false;
		if (preX == 0) check0[preNum] = true;
		else check40[preNum] = true;
	}
}
