import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	
	static ArrayList<int[]> list = new ArrayList<>();
	static int[] movex = {-1, 1, 0, 0};
	static int[] movey = {0, 0, -1, 1};
	
	static int[][] check;
	static int[][] map;
	static int N, M;
	static int size, max, empty;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int [N][M];
		check = new int[N][M];
		list.add(new int[] {0,0});
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) empty++;
				else if (map[i][j] != 6) list.add(new int[] {map[i][j], i, j});
			}
		}
		size = list.size();
		DFS(1, 0);
		System.out.println(empty-max);
	}
	
	static void DFS(int cnt, int sum) {
		if (cnt ==  size) {
			max = Math.max(max, sum);
			return;
		}
		int[] pos = list.get(cnt);
		
		if (pos[0] == 1) {
			for (int k=0; k<4; k++) {
				int room = 0;
				int nextX = pos[1], nextY = pos[2];
				while (true) {
					nextX += movex[k];
					nextY += movey[k];
					
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					
					if (check[nextX][nextY] == 0 && map[nextX][nextY] == 0) {
						check[nextX][nextY] = cnt;
						room++;
					}
				}
				DFS(cnt+1, sum+room);
				
				while (true) {
					nextX -= movex[k];
					nextY -= movey[k];
					if (nextX == pos[1] && nextY == pos[2]) break;
					if (check[nextX][nextY] == cnt) check[nextX][nextY] = 0;
				}
			}
		}
		else if (pos[0] == 2) {
			for (int k=0; k<4; k+=2) {
				int room = 0;
				int nextX = pos[1], nextY = pos[2];
				while (true) {
					nextX += movex[k];
					nextY += movey[k];
					
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					
					if (check[nextX][nextY] == 0 && map[nextX][nextY] == 0) {
						check[nextX][nextY] = cnt;
						room++;
					}
				}
				
				int nextX2 = pos[1], nextY2 = pos[2];
				while (true) {
					nextX2 += movex[k+1];
					nextY2 += movey[k+1];
					
					if (nextX2 < 0 || nextX2 >= N || nextY2 < 0 || nextY2 >= M || map[nextX2][nextY2] == 6) {
						break;
					}
					
					if (check[nextX2][nextY2] == 0 && map[nextX2][nextY2] == 0) {
						check[nextX2][nextY2] = cnt;
						room++;
					}
				}
				
				DFS(cnt+1, sum+room);
				
				while (true) {
					nextX -= movex[k];
					nextY -= movey[k];
					if (nextX == pos[1] && nextY == pos[2]) break;
					if (check[nextX][nextY] == cnt) check[nextX][nextY] = 0;
				}
				
				while (true) {
					nextX2 -= movex[k+1];
					nextY2 -= movey[k+1];
					if (nextX2 == pos[1] && nextY2 == pos[2]) break;
					if (check[nextX2][nextY2] == cnt) check[nextX2][nextY2] = 0;
				}
			}
		}
		else if (pos[0] == 3) {
			for (int k=0; k<2; k++) {
				int room1 = 0;
				int nextX = pos[1], nextY = pos[2];
				while (true) {
					nextX += movex[k];
					nextY += movey[k];
					
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					
					if (check[nextX][nextY] == 0 && map[nextX][nextY] == 0) {
						check[nextX][nextY] = cnt;
						room1++;
					}
				}
				for (int z=2; z<4; z++) {
					int room = room1;
					int nextX2 = pos[1], nextY2 = pos[2];
					while (true) {
						nextX2 += movex[z];
						nextY2 += movey[z];
						
						if (nextX2 < 0 || nextX2 >= N || nextY2 < 0 || nextY2 >= M || map[nextX2][nextY2] == 6) {
							break;
						}
						
						if (check[nextX2][nextY2] == 0 && map[nextX2][nextY2] == 0) {
							check[nextX2][nextY2] = cnt;
							room++;
						}
					}
					
					DFS(cnt+1, sum+room);

					while (true) {
						nextX2 -= movex[z];
						nextY2 -= movey[z];
						if (nextX2 == pos[1] && nextY2 == pos[2]) break;
						if (check[nextX2][nextY2] == cnt) check[nextX2][nextY2] = 0;
					}
				}
				
				while (true) {
					nextX -= movex[k];
					nextY -= movey[k];
					if (nextX == pos[1] && nextY == pos[2]) break;
					if (check[nextX][nextY] == cnt) check[nextX][nextY] = 0;
				}
			}
		}
		else if (pos[0] == 4) {
			for (int k=0; k<4; k++) {
				int room = 0;
				
				for (int z=0; z<4; z++) {
					if (k == z) continue;
					int nextX = pos[1], nextY = pos[2];
					
					while (true) {
						nextX += movex[z];
						nextY += movey[z];
						
						if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
							break;
						}
						
						if (check[nextX][nextY] == 0 && map[nextX][nextY] == 0) {
							check[nextX][nextY] = cnt;
							room++;
						}
					}
				}
				DFS(cnt+1, sum+room);
				
				for (int z=0; z<4; z++) {
					if (k == z) continue;
					int nextX = pos[1], nextY = pos[2];
					while (true) {
						nextX += movex[z];
						nextY += movey[z];
						
						if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
							break;
						}
						if (check[nextX][nextY] == cnt) check[nextX][nextY] = 0;
					}
				}
			}
		}
		else if (pos[0] == 5) {
			int room = 0;
			for (int k=0; k<4; k++) {
				int nextX = pos[1], nextY = pos[2];
				while (true) {
					nextX += movex[k];
					nextY += movey[k];
					
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					
					if (check[nextX][nextY] == 0 && map[nextX][nextY] == 0) {
						check[nextX][nextY] = cnt;
						room++;
					}
				}
			}
			
			DFS(cnt+1, sum+room);
			
			for (int k=0; k<4; k++) {
				int nextX = pos[1], nextY = pos[2];
				while (true) {
					nextX += movex[k];
					nextY += movey[k];
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6) {
						break;
					}
					if (check[nextX][nextY] == cnt) check[nextX][nextY] = 0;
				}
			}
		}
	}
}
