import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_13549_숨바꼭질_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean[] check = new boolean[100001];
	static int N, K;
	static boolean find;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		BFS();
	}
	
	static void BFS() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[1] - o2[1];
				if (diff == 0) return o1[0] - o2[0];
				else return diff;
			}
		});
		queue.offer(new int[] {N, 0});
		check[N] = true;
		
		int ny, nt;
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int y = pos[0];
			int t = pos[1];
			
			if (y == K) {
				System.out.println(t);
				return;
			}
			
			ny = y << 1;
			if (ny <= K+1 && !check[ny]) {
				queue.offer(new int[] {ny, t});
				check[ny] = true;
			}
			
			nt = t + 1;
			ny = y - 1;
			if (ny >= 0 && !check[ny]) {
				queue.offer(new int[] {ny, nt});
				check[ny] = true;
			}
			
			ny = y + 1;
			if (ny <= K && !check[ny]) {
				queue.offer(new int[] {ny, nt});
				check[ny] = true;
			}
		}
	}
}
