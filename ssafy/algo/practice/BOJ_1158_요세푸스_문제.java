import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1158_요세푸스_문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		int cnt = 1;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			if (cnt == K) {
				sb.append(x).append(", ");
				cnt = 0;
			}
			else queue.offer(x);
			cnt++;
		}
		sb.replace(sb.length()-2, sb.length(), ">");
		
		System.out.println(sb);
	}
}
