import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14226_이모티콘 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[][] check;
	static boolean[] num;
	static int B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		B = Integer.parseInt(br.readLine());
		check = new boolean[B+1][B+1];
		num = new boolean[B+1];
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {2, 2, 1}); // 숫자, 시간, 클립
		
		while (!queue.isEmpty()) {
			int[] x = queue.poll();
			if (x[0] ==  B) return x[1];
			
			if (!num[x[0]]) {
				queue.offer(new int[] {x[0], x[1]+1, x[0]});
				num[x[0]] = true;
			}
			
			int nx1 = x[0] - 1;
			if (nx1 > 2 && !check[nx1][x[2]]) {
				queue.offer(new int[] {nx1, x[1]+1, x[2]});
				check[nx1][x[2]] = true;
			}
			
			int nx2 = x[0] + x[2];
			if (nx2 <= B && !check[nx2][x[2]]) {
				queue.offer(new int[] {nx2, x[1]+1, x[2]});
				check[nx2][x[2]] = true;
			}
		}
		return -1;
	}
}
