import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953_A_B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int A, B, answer = 1;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		A = Integer.parseInt(str[0]);
		B = Integer.parseInt(str[1]);
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(A);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size-- > 0) {
				int x = queue.poll();
				
				if (x == B) return answer;
				
				long nx1 = x << 1;
				if (nx1 <= B) {
					queue.offer((int)nx1);
				}
				
				long nx2 = (long)x * 10 + 1;
				if (nx2 <= B) {
					queue.offer((int)nx2);
				}
			}
			answer++;
		}
		return -1;
	}
}
