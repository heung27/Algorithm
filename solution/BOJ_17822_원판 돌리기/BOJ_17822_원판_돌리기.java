import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17822_원판_돌리기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map, temp;
	static int[] top;
	static int N, M, T;
	static int answer;
	static float avg;
	
	public static void main(String[] args) throws IOException {
		 String[] str = br.readLine().split(" ");
		 N = Integer.parseInt(str[0]);
		 M = Integer.parseInt(str[1]);
		 T = Integer.parseInt(str[2]);
		 
		 map = new int[N+1][M];
		 top = new int[N+1];
		 
		 for (int i=1; i<=N; i++) {
			 str = br.readLine().split(" ");
			 for (int j=0; j<M; j++) {
				 map[i][j] = Integer.parseInt(str[j]);
			 }
		 }
		 
		 while (T-- > 0) {
			 str = br.readLine().split(" ");
			 int x = Integer.parseInt(str[0]);
			 int d = Integer.parseInt(str[1]);
			 int k = Integer.parseInt(str[2]) % M;
			 
			 temp = new int[N+1][M];
			 
			 int tempx = x;
			 while (tempx <= N) {
				 if (d == 0) top[tempx] = (top[tempx] + M - k) % M;
				 else top[tempx] = (top[tempx] + k) % M;
				 tempx += x;
			 }
			 
			 for (int i=1; i<=N; i++) {
				 int index = top[i];
				 for (int j=0; j<M; j++, index=(index+1)%M) {
					 temp[i][j] = map[i][index];
				 }
				 top[i] = 0;
			 }
			 
			 if (!search()) {
				 for (int i=1; i<=N; i++) {
					 for (int j=0; j<M; j++) {
						 if (map[i][j] == 0) continue;
						 
						 if (map[i][j] < avg) {
							 map[i][j]++;
						 }
						 else if (map[i][j] > avg) {
							 map[i][j]--;
						 }
					 }
				 }
			 }
		 }
		 
		 for (int i=1; i<=N; i++) {
			 for (int j=0; j<M; j++) {
				 answer += map[i][j];
			 }
		 }
		 
		 System.out.println(answer);
	}
	
	static boolean search() {
		boolean check = false;
		int sum = 0, cnt = 0;
		for (int i=1; i<=N; i++) {
			for (int j=0; j<M; j++) {
				if (temp[i][j] == 0) {
					map[i][j] = 0;
					continue;
				}
				boolean t = false;
				
				int ny = (j+1)%M;
				if (temp[i][j] == temp[i][ny]) {
					map[i][j] = 0;
					if (ny == 0) map[i][ny] = 0;
					else map[i][ny] = -1;
					if (!check) check = true;
					t = true;
				}
				
				if (i < N && temp[i][j] == temp[i+1][j]) {
					map[i][j] = 0;
					map[i+1][j] = -1;
					if (!check) check = true;
					t = true;
				}
				
				if (!t) {
					if (map[i][j] == -1) map[i][j] = 0;
					else map[i][j] = temp[i][j];
				}
				
				if (map[i][j] != 0) {
					sum += map[i][j];
					cnt++;
				}
			}
		}
		if (!check) avg = (float)sum/cnt;
		return check;
	}
}
