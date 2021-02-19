import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범_빌딩 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movek = {-1, 0, 0, 0, 0, 1};
	static int[] movex = {0, -1, 1, 0, 0, 0};
	static int[] movey = {0, 0, 0, -1, 1, 0};
	
	static Queue<int[]> queue = new LinkedList<>();
	static char[][][] map;
	static boolean[][][] check;
	static int L, R, C;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		while (true) {
			String[] str = br.readLine().split(" ");
			L = Integer.parseInt(str[0]);
			R = Integer.parseInt(str[1]);
			C = Integer.parseInt(str[2]);
			
			if (L == 0 && R == 0 && C == 0) break;
			
			map = new char[L][R][C];
			check = new boolean[L][R][C];
			answer = 0;
			
			for (int k=0; k<L; k++) {
				for (int i=0; i<R; i++) {
					String s = br.readLine();
					for (int j=0; j<C; j++) {
						map[k][i][j] = s.charAt(j);
						if (map[k][i][j] == 'S') {
							queue.offer(new int[] {k,i,j});
							check[k][i][j] = true;
						}
					}
				}
				br.readLine();
			}
			
			if (BFS()) sb.append("Escaped in ").append(answer).append(" minute(s).");
			else sb.append("Trapped!");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean BFS() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int[] pos = queue.poll();
				if (map[pos[0]][pos[1]][pos[2]] == 'E') {
					queue.clear();
					return true;
				}
				
				for (int i=0; i<6; i++) {
					int nk = pos[0] + movek[i];
					int nx = pos[1] + movex[i];
					int ny = pos[2] + movey[i];
					
					if (nk < 0 || nk >= L || nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					
					if (!check[nk][nx][ny] && map[nk][nx][ny] != '#') {
						check[nk][nx][ny] = true;
						queue.offer(new int[] {nk,nx,ny});
					}
				}
			}
			answer++;
		}
		return false;
	}
}
