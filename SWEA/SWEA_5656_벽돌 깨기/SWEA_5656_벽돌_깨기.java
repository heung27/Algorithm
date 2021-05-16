import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌_깨기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 0, 1, 0};
	static int[] movey = {0, 1, 0, -1};
	
	static int[][] map;
	static int N, W, H;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			
			N = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			H = Integer.parseInt(str[2]);
			
			map = new int[H][W];
			answer = Integer.MAX_VALUE;
			
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			DFS(0, map);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());;
		bw.flush();
	}
	
	static void DFS(int cnt, int[][] map) {
		if (cnt == N) {
			int sum = 0;
			for (int h=0; h<H; h++) {
				for (int w=0; w<W; w++) {
					if (map[h][w] != 0) sum++;
				}
			}
			answer = Math.min(sum, answer);
			return;
		}
		
		int[][] temp = new int[H][W];
		for (int j=0; j<W; j++) {
			temp = copy(map);
			drop(j, temp);
			DFS(cnt+1, temp);
		}
	}
	
	static int[][] copy(int[][] map) {
		int[][] temp = new int[H][W];
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	
	static void drop(int j, int[][] temp) {
		for (int i=0; i<H; i++) {
			if (temp[i][j] != 0) {
				remove(i, j, temp);
				break;
			}
		}
		all_drop(temp);
	}
	
	static void remove(int i, int j, int[][] temp) {
		int cnt = temp[i][j] - 1;
		temp[i][j] = 0;
		
		for (int d=0; d<4; d++) {
			int nx = i, ny = j;
			
			for (int c=0; c<cnt; c++) {
				nx += movex[d];
				ny += movey[d];
				
				if (nx < 0 || nx >= H || ny < 0 || ny >= W) break;
				
				remove(nx, ny, temp);
			}
		}
	}
	
	static void all_drop(int[][] temp) {
		for (int j=0; j<W; j++) {
			int index = H-1;
			for (int i=H-1; i>=0; i--) {
				if (temp[i][j] != 0) {
					int x = temp[i][j];
					temp[i][j] = 0;
					temp[index--][j] = x;
				}
			}
		}
	}
}
