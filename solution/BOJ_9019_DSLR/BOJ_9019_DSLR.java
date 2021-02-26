import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int[] parent;
	static char[] chars;
	static int A, B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			String[] str = br.readLine().split(" ");
			A = Integer.parseInt(str[0]);
			B = Integer.parseInt(str[1]);
			parent = new int[10000];
			chars = new char[10000];
			Arrays.fill(parent, -1);
			
			BFS();
			
			sb = new StringBuilder();
			sb.append("\n");
			while (B != A) {
				sb.append(chars[B]);
				B = parent[B];
			}
			bw.write(sb.reverse().toString());
		}
		bw.flush();
	}
	
	static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(A);
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			
			int nx1 = (x * 2) % 10000;
			if(parent[nx1] == -1) {
				parent[nx1] = x;
				chars[nx1] = 'D';
				queue.offer(nx1);
			}
			
			int nx2 = x - 1;
			if (nx2 < 0) nx2 = 9999;
			if(parent[nx2] == -1) {
				parent[nx2] = x;
				chars[nx2] = 'S';
				queue.offer(nx2);
			}
			
			int temp = x / 1000;
			int nx3 = (x % 1000) * 10 + temp;
			if(parent[nx3] == -1) {
				parent[nx3] = x;
				chars[nx3] = 'L';
				queue.offer(nx3);
			}
			
			temp = x % 10;
			int nx4 = (x / 10) + temp * 1000;
			if(parent[nx4] == -1) {
				parent[nx4] = x;
				chars[nx4] = 'R';
				queue.offer(nx4);
			}
			
			if (parent[B] != -1) return;
		}
	}
	
}
