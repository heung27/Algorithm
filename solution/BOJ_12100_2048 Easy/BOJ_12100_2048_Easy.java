import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12100_2048_Easy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] map;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		move(0, map); 
		System.out.println(answer);
	}
	
	static void move(int cnt, int[][] temp_map) {
		if (cnt == 5) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (temp_map[i][j] != 0 && answer < temp_map[i][j]) answer = temp_map[i][j];
				}
			}
			return;
		}
		up(temp_map);
		move(cnt+1, map);
		
		down(temp_map);
		move(cnt+1, map);
		
		left(temp_map);
		move(cnt+1, map);
		
		right(temp_map);
		move(cnt+1, map);
	}
	
	static void up(int[][] move_map) {
		int[][] temp_map = new int[N][N];
		
		for (int j=0; j<N; j++) {
			int temp = 0, cnt = 0;
			for (int i=0 ; i<N; i++) {
				if (move_map[i][j] == 0) continue;
				else if(temp == 0) {
					temp = move_map[i][j];
					continue;
				}
				if (temp == move_map[i][j]) {
					temp_map[cnt++][j] = temp<<1;
					temp = 0;
				}
				else {
					temp_map[cnt++][j] = temp;
					temp = move_map[i][j];
				}
			}
			temp_map[cnt][j] = temp;
		}
		map = temp_map;
	}
	
	static void down(int[][] move_map) {
		int[][] temp_map = new int[N][N];
		
		for (int j=0; j<N; j++) {
			int temp = 0, cnt = N-1;
			for (int i=N-1 ; i>=0; i--) {
				if (move_map[i][j] == 0) continue;
				else if(temp == 0) {
					temp = move_map[i][j];
					continue;
				}
				if (temp == move_map[i][j]) {
					temp_map[cnt--][j] = temp<<1;
					temp = 0;
				}
				else {
					temp_map[cnt--][j] = temp;
					temp = move_map[i][j];
				}
			}
			temp_map[cnt][j] = temp;
		}
		map = temp_map;
	}
	
	static void left(int[][] move_map) {
		int[][] temp_map = new int[N][N];
		
		for (int i=0 ; i<N; i++) {
			int temp = 0, cnt = 0;
			for (int j=0; j<N; j++) {
				if (move_map[i][j] == 0) continue;
				else if(temp == 0) {
					temp = move_map[i][j];
					continue;
				}
				if (temp == move_map[i][j]) {
					temp_map[i][cnt++] = temp<<1;
					temp = 0;
				}
				else {
					temp_map[i][cnt++] = temp;
					temp = move_map[i][j];
				}
			}
			temp_map[i][cnt] = temp;
		}
		map = temp_map;
	}
	
	static void right(int[][] move_map) {
		int[][] temp_map = new int[N][N];
		
		for (int i=0 ; i<N; i++) {
			int temp = 0, cnt = N-1;
			for (int j=N-1; j>=0; j--) {
				if (move_map[i][j] == 0) continue;
				else if(temp == 0) {
					temp = move_map[i][j];
					continue;
				}
				if (temp == move_map[i][j]) {
					temp_map[i][cnt--] = temp<<1;
					temp = 0;
				}
				else {
					temp_map[i][cnt--] = temp;
					temp = move_map[i][j];
				}
			}
			temp_map[i][cnt] = temp;
		}
		map = temp_map;
	}
}
