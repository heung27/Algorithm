import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤_커브 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {0, -1, 0, 1}; // 우상좌하
	static int[] movey = {1, 0, -1, 0};
	
	static Stack<int[]> stack = new Stack<>();
	static Stack<int[]> temp = new Stack<>();
	static boolean[][] map = new boolean[101][101];
	static int N, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		while (N-- > 0) {
			String[] str = br.readLine().split(" ");
			int y = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			int d = Integer.parseInt(str[2]);
			int g = Integer.parseInt(str[3]);
			
			stack.clear();
			for (int i=0; i<2; i++) {
				map[x][y] = true;
				stack.add(new int[] {x, y});
				x += movex[d];
				y += movey[d];
			}
			
			while (g-- > 0) {
				temp.addAll(stack);
				int[] end = temp.pop();
				
				while (!temp.isEmpty()) {
					int[] pos = temp.pop(); // 얕은 복사
					int tx = pos[0]; // 깊은 복사
					int ty = pos[1];
					
					tx -= end[0];
					ty -= end[1];
					
					int temp = tx;
					tx = ty;
					ty = -temp;
					
					tx += end[0];
					ty += end[1];
					
					map[tx][ty] = true;
					stack.add(new int[] {tx, ty});
				}
			}
		}
		
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
