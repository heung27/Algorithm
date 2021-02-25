import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14499_주사위_굴리기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {0, 0, 0, -1, 1};
	static int[] movey = {0, 1, -1, 0, 0};
	static int[] dice = new int[6]; // 윗면, 뒷면, 오른쪽면, 왼쪽면, 앞면, 밑면
	
	static int[][] map;
	static int N, M, X, Y, K;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		X = Integer.parseInt(str[2]);
		Y = Integer.parseInt(str[3]);
		K = Integer.parseInt(str[4]);
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while (K-- > 0) {
			int d = Integer.parseInt(st.nextToken());
			
			int nx = X + movex[d];
			int ny = Y + movey[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			// 윗면, 뒷면, 오른쪽면, 왼쪽면, 앞면, 밑면
			int top = dice[0];
			
			if (d == 1) {
				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[2];
				dice[2] = top;
			}
			else if (d == 2) {
				dice[0] = dice[2];
				dice[2] = dice[5];
				dice[5] = dice[3];
				dice[3] = top;
			}
			else if (d == 3) {
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[1];
				dice[1] = top;
			}
			else {
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[4];
				dice[4] = top;
			}
			
			X = nx;
			Y = ny;
			
			if (map[nx][ny] == 0) map[nx][ny] = dice[5];
			else {
				dice[5] = map[nx][ny];
				map[nx][ny] = 0;
			}
			
			sb.append(dice[0]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
}
