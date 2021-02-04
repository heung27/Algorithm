import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static class Pos {
		int x;
		int y;
		int z;
		public Pos(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static int[] moveX = {-1, 1, 0, 0, 0, 0}; // 상, 하, 좌, 우, up, down 
	static int[] moveY = {0, 0, -1, 1, 0, 0};
	static int[] moveZ = {0, 0, 0, 0, 1, -1};
	static int[][][] box;
	static int X, Y, Z, answer, cnt, tomato;
	static Queue<Pos> queue = new LinkedList<>(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] str = br.readLine().split(" ");
		Y = Integer.parseInt(str[0]); // 가로
		X = Integer.parseInt(str[1]); // 세로
		Z = Integer.parseInt(str[2]); // 높이
		box = new int[X][Y][Z];
		for (int k=0; k<Z; k++) {
			for (int i=0; i<X; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<Y; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) queue.offer(new Pos(i, j, k)); // 익은 토마토의 좌표 offer
					else if (box[i][j][k] == 0) cnt++; // 덜 익은 토마토의 개수 count
				}
			}
		}
		BFS();
	}
	
	static void BFS() {
		int x, y, z;
		while (!queue.isEmpty()) {
			if (tomato == cnt) { // 익게 된 토마토 개수와 덜 익은 토마토 개수가 같으면 전부 익은 것
				System.out.println(answer); 
				return;
			}
			
			int size = queue.size();
			while (size-- > 0) {
				Pos pos = queue.poll();
				
				for (int i=0; i<6; i++) {
					x = pos.x+moveX[i]; // 다음 위치
					y = pos.y+moveY[i];
					z = pos.z+moveZ[i];
					if (x < 0 || x >= X || y < 0 || y >= Y || z < 0 || z >= Z) continue;
					if (box[x][y][z] == 0) {
						queue.offer(new Pos(x, y, z)); // 익지 않았던 토마토의 좌표 offer
						box[x][y][z] = 1; // 해당 토마토가 익음
						tomato++; // 익게 된 토마토 개수 count
					}
				}
			}
			answer++; // 시간 증가
		}
		System.out.println(-1);
	}
}
