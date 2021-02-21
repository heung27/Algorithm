import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 1};
	static int[] movey = {1, 1, 1, 0};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		map = new int[19][19];
		for (int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean t = false;
		a: for (int i=0; i<19; i++) {
			for (int j=0; j<19; j++) {
				if (map[i][j] != 0) {
					if (sol(i, j)) { // 오목이 생겼으면 break
						t = true;
						break a;
					}
				}
			}
		}
		if (!t) sb.append(0); // 끝까지 오목이 없으면 승부가 나지않음
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean sol(int x, int y) {
		for (int i=0; i<4; i++) {
			int bx = x-movex[i], by = y-movey[i]; // 현재 보고있는 자리의 한 칸 뒤
			if (bx >= 0 && bx < 19 && by >= 0 && map[bx][by] == map[x][y]) continue; // 한 칸 뒤가 있고 지금 돌과 색이 같으면 보지않음
			
			int nx = x, ny = y;
			int cnt = 1;
			for ( ; ; cnt++) { // 4가지 방향으로 쭉 탐색
				nx += movex[i];
				ny += movey[i];
				
				if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || map[nx][ny] != map[x][y]) break;
			}
			if (cnt == 5) { // 오목이면 true 리턴
				sb.append(map[x][y]).append("\n").append(x+1).append(" ").append(y+1);
				return true;
			}
		}
		return false;
	}
}
