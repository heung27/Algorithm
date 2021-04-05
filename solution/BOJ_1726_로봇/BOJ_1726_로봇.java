import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1726_로봇 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Node {
		int x, y;
		int d;
		int cnt;
		int k;
		
		public Node(int x, int y, int d, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	static int[] movex = {0, 1, 0, -1}; // 오른 아래 왼 위 
	static int[] movey = {1, 0, -1, 0};
	
	static int[][] map, view;
	static Node start, end;
	static int R, C, answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		map = new int[R][C];
		view = new int[R][C];
		answer = Integer.MAX_VALUE;
		
		for (int i=0; i<R; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		str = br.readLine().split(" ");
		int x1 = Integer.parseInt(str[0])-1;
		int y1 = Integer.parseInt(str[1])-1;
		int d1 = Integer.parseInt(str[2])-1;
		
		if (d1 == 1) d1 = 2;
		else if (d1 == 2) d1 = 1;
		start = new Node(x1, y1, d1, 0, 0);
		
		str = br.readLine().split(" ");
		int x2 = Integer.parseInt(str[0])-1;
		int y2 = Integer.parseInt(str[1])-1;
		int d2 = Integer.parseInt(str[2])-1;
		
		if (d2 == 1) d2 = 2;
		else if (d2 == 2) d2 = 1;
		end = new Node(x2, y2, d2, 0, 0);
		
		BFS();
		System.out.println(answer);
	}
	
	static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start.x, start.y, start.d, 0, 0));
		view[start.x][start.y] = -1; 
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				Node node = queue.poll();
				
				if (node.x == end.x && node.y == end.y) {
					int cnt = 0;
					
					if (node.d == end.d) cnt = node.cnt;
					else if ((node.d + 2) % 4 == end.d) cnt = node.cnt+2;
					else cnt = node.cnt+1;
					
					answer = Math.min(answer, cnt);
				}
				
				int cnt = node.cnt, d = node.d;
				if (node.k == 3) node.k = 0;
				
				for (int i=0; i<4; i++, d=(d+1)%4, cnt++) { // 회전
					int nx = node.x + movex[d];
					int ny = node.y + movey[d];
					
					if (i == 3) cnt -= 2;
					
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 1 || (node.cnt != 0 && i == 2)) continue;
					
					int temp_cnt = cnt;
					if (i != 0 || node.k == 0) temp_cnt++;
					
					if (view[nx][ny] == 0 || view[nx][ny] > temp_cnt - 2) {
						if (i == 0) queue.offer(new Node(nx, ny, d, temp_cnt, node.k+1));
						else queue.offer(new Node(nx, ny, d, temp_cnt, 1));
						view[nx][ny] = temp_cnt;
					}
				}
			}
		}
	}
}
